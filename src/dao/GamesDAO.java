package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Games;
import model.Scores;

public class GamesDAO {

	// Gamesテーブルからすべての情報を取得する
	public List<Games> selectAll() {
		Connection conn = null;
		List<Games> gameList = new ArrayList<>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する
			String sql = "SELECT * FROM GAMES ORDER BY RAND()";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Games game = new Games(
						rs.getInt("id"),
						rs.getString("quiz"),
						rs.getString("choice_1"),
						rs.getString("choice_2"),
						rs.getString("choice_3"),
						rs.getString("choice_4"),
						rs.getString("correct"),
						rs.getInt("score"));
				gameList.add(game);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			gameList = null; // エラー時はnullを返す（または適切なエラー処理を行う）
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			gameList = null; // エラー時はnullを返す（または適切なエラー処理を行う）
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					gameList = null; // エラー時はnullを返す（または適切なエラー処理を行う）
				}
			}
		}

		// 結果を返す
		return gameList;
	}

	public boolean insert(Scores score) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO Scores(id,user_id, score) "
					+ "VALUES (NULL,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, score.getUser_id());
			pStmt.setInt(1, score.getScore());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

}
