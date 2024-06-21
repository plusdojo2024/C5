package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Books;

//Books,Channelsテーブルアクセス用DAO。

public class BooksDAO {

	//booksテーブルから、指定したChannel_id(int)のデータ(books)を複数取得する。

	public List<Books> getChannelBooks(int channel_id) {
		List<Books> booksList = new ArrayList<Books>();
		Connection conn = null;

		try {

			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する
			String sql = "SELECT item_name FROM handbook WHERE  channel_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を完成させる
			pStmt.setInt(1, channel_id);


//			if (channel_id == 1) {
//			pStmt.setInt(1, 1 );
//			}
//			else if (channel_id.getChannel_id() == 2) {
//			pStmt.setInt(1, 2);
//			}
//			else if (channel_id.getChannel_id() == 3) {
//			pStmt.setInt(1, 3);
//			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();


			// 結果表をコレクションにコピーする
<<<<<<< HEAD
			while (rs.next()) {
				Books item = new Books(
						rs.getInt("id"),
						rs.getInt("channel_id"),
						rs.getInt("item_id"),
						rs.getString("item_name"),
						rs.getString("item_icon"),
						rs.getString("explanation")
						);
				booksList.add(item);
			}
=======
			/*			while (rs.next()) {
							Books item = new Books(
									rs.getInt("id"),
									rs.getInt("channel_id"),
									rs.getInt("item_id"),
									rs.getString("item_name"),
									rs.getString("item_icon"),
									rs.getString("explanation")
									);
							booksList.add(item);
						}*/
>>>>>>> 096450f686fb3ac6feeb1c2e4ff4cb790c82599b


		}
		catch (SQLException e) {
			e.printStackTrace();
			booksList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			booksList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					booksList = null;
				}
			}
		}




		return booksList;
	}

}
