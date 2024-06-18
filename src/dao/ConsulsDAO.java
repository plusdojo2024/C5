package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Consuls;

	public class ConsulsDAO {

		// 最大の投稿IDを取得するメソッド

		public int getMaxPostId() {

		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    int maxPostId = 0;

		    try {
		    	// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する
				String sql = "SELECT MAX(post_id) FROM consuls";

		        pstmt = conn.prepareStatement(sql);
		        rs = pstmt.executeQuery();

		        if (rs.next()) {
		            maxPostId = rs.getInt(1);
		        }
		    } catch (ClassNotFoundException | SQLException e) {

		        e.printStackTrace();

		    } finally {

		    }

		    return maxPostId;
		}


		// 投稿IDの登録（consulsテーブルを検索して、投稿IDのMax値を検索して、その値に+1をする。）

	    public int insertAndGetGeneratedPostId(Consuls consuls) {

	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        int generatedPostId = -1;

	        try {
	        	// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// 現在の最大の投稿IDを取得
				int maxPostId = getMaxPostId();

				// 新しい投稿IDを生成
				int newPostId = maxPostId + 1;

				// SQL文を準備する
	            String sql = "INSERT INTO consuls (post_id, user_id, channel_id, post_number, post_content, post_time) VALUES (?, ?, ?, ?, ?, ?)";

	            pstmt = conn.prepareStatement(sql);

	            pstmt.setInt(1, newPostId);// 投稿ID
	            pstmt.setInt(2, consuls.getUser_id());// ユーザーID
	            pstmt.setInt(3, consuls.getChannel_id());// チャンネルID
	            pstmt.setInt(4, consuls.getPost_number());// 投稿番号
	            pstmt.setString(5, consuls.getPost_content());// 投稿内容
	            pstmt.setTimestamp(6, consuls.getPost_time());// 投稿時間


				// SQL文を実行し、影響を受けた行数を取得
				int affectedRows = pstmt.executeUpdate();

				// 影響を受けた行があれば、生成された投稿IDを設定
				if (affectedRows > 0) {
				     	generatedPostId = newPostId;
				}
			} catch (ClassNotFoundException | SQLException e) {
				    	e.printStackTrace();

			} finally {

				try {
				         if (rs != null) {
				               rs.close();
				         }
				         if (pstmt != null) {
				               pstmt.close();
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


		// 引数questionで指定された質問＆返信を登録し、成功したらtrueを返す

		public boolean insert(Consuls question) {

			Connection conn = null;
			boolean result = false;

			try {

				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
				String sql = "INSERT INTO Consuls VALUES (NULL,?,?,?,?,?,CURRENT_TIMESTAMP)";

				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (question.getPost_content() != null && !question.getPost_content().equals("")) {
					pStmt.setString(1, question.getPost_content());
				}
				else {
					pStmt.setString(1, "（未設定）");
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			// 結果を返す
			return result;
		}



		// 引数questionで指定された質問＆返信を更新し、成功したらtrueを返す

		public boolean update(Consuls question) {

			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する(書き換え必要な部分↓)主キーがWHEREで指定される。
				String sql = "UPDATE Consuls SET post_content=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (question.getPost_content() != null && !question.getPost_content().equals("")) {
					pStmt.setString(1, question.getPost_content());
				}
				else {
					pStmt.setString(1, null);
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}



		// 引数numberで指定された質問＆返信を削除し、成功したらtrueを返す

		public boolean delete(int number) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する
				String sql = "DELETE FROM Consuls WHERE number=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setInt(1, number);

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}
	}
