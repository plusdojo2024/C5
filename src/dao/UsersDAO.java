package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Users;

public class UsersDAO {
	//ログイン
	public boolean isLoginOK(Users idpw) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "pw");

			// SELECT文を準備する
			String sql = "SELECT COUNT(*) FROM Users WHERE user_name = ? AND password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, idpw.getUser_name());
			pStmt.setString(2, idpw.getPassword());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("COUNT(*)") == 1) {
				loginResult = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;

	}

	//新規登録
	public boolean insert(Users user) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "pw");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO Users VALUES (NULL,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//String child_birthday = new SimpleDateFormat("yyyy-MM-dd").format(user.getChild_birthday());

			// 登録：SQL文を完成させる→名前などを入力するところ
			if (user.getUser_name() != null && !user.getUser_name().equals("")) {
				pStmt.setString(1, user.getUser_name());
			}
			if (user.getPassword() != null && !user.getPassword().equals("")) {
				pStmt.setString(2, user.getPassword());
			}
			if (user.getChild_birthday() != null && !user.getChild_birthday().equals("")) {
				pStmt.setDate(3,user.getChild_birthday());
			} else {
				pStmt.setString(3, "（未設定）");

			}
			if (user.getChild_name() != null && !user.getChild_name().equals("")) {
				pStmt.setString(4, user.getChild_name());
			} else {
				pStmt.setString(4, "（未設定）");

			}
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
