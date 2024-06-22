package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Comments;
import model.Consul_comment;
import model.Consuls;

public class ConsulsDAO {

	//相談投稿
	public int insert1(Consuls consuls) {

		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		int generatedPostId = -1;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する
			String sql = "INSERT INTO Consuls  VALUES (NULL,?, ?, ?, CURRENT_TIMESTAMP)";
			pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, consuls.getUser_id());
			pStmt.setInt(2, consuls.getChannel_id());
			pStmt.setString(3, consuls.getConsul_content());

			// SQL文を実行
			generatedPostId = pStmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pStmt != null) {
					pStmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 生成された投稿IDを返す
		return generatedPostId;
	}

	//コメント投稿
	public int insert2(Comments comment) {

		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		int generatedPostId = -1;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する
			String sql = "INSERT INTO Comments  VALUES (NULL,?, ?, ?, CURRENT_TIMESTAMP)";
			pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, comment.getUser_id());
			pStmt.setInt(2, comment.getConsul_id());
			pStmt.setString(3, comment.getComment_content());

			// SQL文を実行
			generatedPostId = pStmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pStmt != null) {
					pStmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 生成された投稿IDを返す
		return generatedPostId;
	}

	// searchServletで検索項目を指定し、検索結果のリストを返す
	public List<Consul_comment> select(int cahnnel_id) {
		Connection conn = null;
		List<Consul_comment> cardList = new ArrayList<Consul_comment>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			//				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する
			String sql = "SELECT consul_content,comment_content,consuls.id,consul_id,consul_user.user_name as consul_name,"
					+ "comment_user.user_name as comment_name,consul_time,comment_time "
					+ "	FROM Consuls "
					+ " left join comments on consuls.id = comments.consul_id "
					+ " left join users as consul_user on consul_user.id = consuls.user_id "
					+ " left join users as comment_user on comment_user.id = comments.user_id "
					+ "	WHERE channel_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, cahnnel_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Consul_comment record = new Consul_comment(
						rs.getString("consul_content"),
						rs.getString("comment_content"),
						rs.getInt("id"),
						rs.getInt("consul_id"),
						rs.getString("consul_name"),
						rs.getString("comment_name"),
						rs.getTimestamp("consul_time"),
						rs.getTimestamp("comment_time"));
				cardList.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}
}