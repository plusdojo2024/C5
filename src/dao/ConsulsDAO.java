package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Consuls;

	public class ConsulsDAO {

		public static void main(String[] args) {
			ConsulsDAO dao = new ConsulsDAO();
			System.out.println(dao.getMaxPostId());

		}

		// 最大の投稿IDを取得するメソッド
		public int getMaxPostId() {

			Connection conn = null;
		    PreparedStatement pStmt = null;
		    ResultSet rs = null;
		    int maxPostId = 0;

		    try {
		    	// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "pw");

				// SQL文を準備する
				String sql = "SELECT MAX(post_id) FROM consuls";
		        pStmt = conn.prepareStatement(sql);
		        rs = pStmt.executeQuery();

		        if (rs.next()) {
		            maxPostId = rs.getInt(1);
		        }

		    } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();

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

	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	        }
		    return maxPostId;
		}


		// 投稿IDの登録（consulsテーブルを検索して、投稿IDのMax値を検索して、その値に+1をする。）

		public int insertAndGetGeneratedPostId(Consuls consuls) {

			Connection conn = null;
	        PreparedStatement pStmt = null;
	        ResultSet rs = null;
	        int generatedPostId = -1;

	        try {
	        	// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "pw");

				// 現在の最大の投稿IDを取得
				int maxPostId = getMaxPostId();

				// 新しい投稿IDを生成
				int post_id = maxPostId + 1;

				// SQL文を準備する
	            String sql = "INSERT INTO Consuls (id,post_id, user_id, channel_id, post_number, post_content, post_time) VALUES (NULL,?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";
	            pStmt = conn.prepareStatement(sql);

	            // SQL文を完成させる

	            pStmt.setInt(1, post_id); // 投稿ID
	            pStmt.setInt(2, consuls.getUser_id()); // ユーザーID
	            pStmt.setInt(3, consuls.getChannel_id()); // チャンネルID
	            pStmt.setInt(4, consuls.getPost_number()); // 投稿番号
	            pStmt.setString(5, consuls.getPost_content()); // 投稿内容

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
	    public static void main1(String[] args) {
			ConsulsDAO dao = new ConsulsDAO();
			System.out.println(dao.insertAndGetGeneratedPostId(null));
		}
	}