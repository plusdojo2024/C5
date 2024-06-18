package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Consuls;

	public class ConsulsDAO {
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Consuls> select(Consuls question) {
			Connection conn = null;
			List<Consuls> infoList = new ArrayList<Consuls>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する
				String sql = "SELECT * FROM consuls WHERE post_content LIKE ?";
				//↑検索で出てくるものを変更したかったらここを変更する。

				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (question.getPost_content() != null) {
					pStmt.setString(1, "%" + question.getPost_content() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
					while (rs.next()) {
						Consuls record = new Consuls(
						);
						infoList.add(record);
					}
				}

			catch (SQLException e) {
				e.printStackTrace();
				infoList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				infoList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						infoList = null;
					}
				}
			}

			// 結果を返す
			return infoList;
		}

		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Consuls question) {
			Connection conn = null;
			boolean result = false;

			try {

				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");


				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");


				// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
				//NULLは自動生成のナンバーのこと↓
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

		// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
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

		// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
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
