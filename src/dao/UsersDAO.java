package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Userpw;
import model.Users;

public class UsersDAO {
	//ログイン
	public Users isLoginOK(Userpw userpw) {
		Connection conn = null;
//		boolean loginResult = false;
		Users user = new Users();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SELECT文を準備する
			String sql = "SELECT * ,COUNT(*) FROM Users WHERE user_name = ? AND password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userpw.getUser_name());
			pStmt.setString(2, userpw.getPassword());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("COUNT(*)") == 1) {
//				loginResult = true;
				user.setId(rs.getInt("id"));
				user.setUser_name(rs.getString("user_name"));
				user.setChild_name(rs.getString("child_name"));
				user.setChild_birthday(rs.getDate("child_birthday"));
//				user.setUser_name(rs.getString("user_name"));

			}else {
				user = null;
			}

			} catch (SQLException e) {
				e.printStackTrace();
//				loginResult = false;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
//				loginResult = false;
			} finally {

				// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
//					loginResult = false;
				}
			}
		}

		// 結果を返す
		return user;

	}


	//新規登録
	public boolean insert(Users user) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO Users(id,user_name,password,child_name,child_birthday) VALUES (NULL,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//String child_birthday = new SimpleDateFormat("yyyy-MM-dd").format(user.getChild_birthday());

			// 登録：SQL文を完成させる→名前などを入力するところ
				pStmt.setString(1, user.getUser_name());
				pStmt.setString(2, user.getPassword());
				pStmt.setString(3, user.getChild_name());
				pStmt.setDate(4,user.getChild_birthday());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		finally {
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
