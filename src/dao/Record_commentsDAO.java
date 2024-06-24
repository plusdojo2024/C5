package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.record_comments;

public class Record_commentsDAO {
	//コメント表示

	public List<record_comments> select(Date date, int user_id) {

		Connection conn = null;
		List<record_comments> commentList = new ArrayList<record_comments>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する
			String sql = "select * from record_comments "
					+ "where cast(comment_timestamp as date) = ? AND user_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQLを完成させる

			pStmt.setDate(1, date);
			pStmt.setInt(2, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をjavaが扱いやすいコレクション（リスト）に変換する
			while (rs.next()) {
				record_comments comment = new record_comments();
				comment.setComment_timestamp(rs.getTimestamp("comment_timestamp"));
				comment.setComment(rs.getString("comment"));
				commentList.add(comment);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			commentList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			commentList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					commentList = null;
				}

			}
		}

		// 結果を返す
		return commentList;
	}

	//bc_sampleテーブルにレコードを追加
	public boolean insert(record_comments comment) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する
			String sql = "INSERT INTO record_comments (comment_id,user_id,comment,comment_timestamp) "
					+ "VALUES (NULL,?,?,CURRENT_TIMESTAMP)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, comment.getUser_id());
			pStmt.setString(2, comment.getComment());

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
