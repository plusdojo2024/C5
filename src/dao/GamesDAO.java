package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Games;

public class GamesDAO {

    // Gamesテーブルからすべての情報を取得する
    public List<Games> select(Games Game) {
        Connection conn = null;
        List<Games> gameList = new ArrayList<>();

        try {
            // JDBCドライバを読み込む
            Class.forName("org.h2.Driver");

            // データベースに接続する
            conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

//            "jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw"
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
                    rs.getInt("score")
                );
                gameList.add(game);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            gameList = null; // エラー時はnullを返す（または適切なエラー処理を行う）
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            gameList = null; // エラー時はnullを返す（または適切なエラー処理を行う）
        }
        finally {
            // データベースを切断
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                    gameList = null; // エラー時はnullを返す（または適切なエラー処理を行う）
                }
            }
        }

        // 結果を返す
        return gameList;
    }
}
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import model.Games;
//
//public class GamesDAO {
//	// searchServletで検索項目を指定し、検索結果のリストを返す
////	public List<Games> select(Games game) {
//	public List<Games> selectAll() {
//		Connection conn = null;
//		List<Games> gameList = new ArrayList<>();
//
//		try {
//			// JDBCドライバを読み込む
//			Class.forName("org.h2.Driver");
//
//			// データベースに接続する
//			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");
//
//			// SQL文を準備する 全ての項目を選択
//			String sql = "SELECT * FROM Games";
////					+ " WHERE company LIKE ? AND address LIKE ? ORDER BY number";
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//			// SQL文を完成させる
////			if (game.getQuiz() != null) {
////				pStmt.setString(1, "%" + game.getQuiz() + "%");
////			}
////			else
////			{
////				pStmt.setString(1, "%");
////			}
////			if (card.getAddress() != null) {
////				pStmt.setString(2, "%" + card.getAddress() + "%");
////			}
////			else {
////				pStmt.setString(2, "%");
////			}
//
//			// SQL文を実行し、結果表を取得する
//			ResultSet rs = pStmt.executeQuery();
//
//			// 結果表をコレクションにコピーする
//			while (rs.next()) {
//				Games record = new Games(
//				rs.getInt("id"),
//				rs.getString("quiz"),
//				rs.getString("choice_1"),
//				rs.getString("choice_2"),
//				rs.getString("choice_3"),
//				rs.getString("choice_4"),
//				rs.getString("correct"),
//				rs.getInt("score")
//				);
//				gameList.add(record);
//			}
//
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//			gameList = null;
//		}
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			gameList = null;
//		}
//		finally {
//			// データベースを切断
//			if (conn != null) {
//				try {
//					conn.close();
//				}
//				catch (SQLException e) {
//					e.printStackTrace();
//					gameList = null;
//				}
//			}
//		}
//
//		// 結果を返す
//		return gameList;
//	}
//}
//
