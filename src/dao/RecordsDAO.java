package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RecordTime;
import model.Record_excretions;
import model.Record_meals;
import model.Record_sleeps;
import model.Records;
import model.UploadFile;

public class RecordsDAO {
	// 記録書に指定の日付のデータを表示する
	public List<RecordTime> select(Date date, int user_id) {
		Connection conn = null;
		List<RecordTime> cardList = new ArrayList<RecordTime>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する
			String sql = "select * from record_meals "
					+ "where cast(meal_timestamp as date) = ? AND user_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQLを完成させる

			pStmt.setDate(1, date);
			pStmt.setInt(2, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をjavaが扱いやすいコレクション（リスト）に変換する
			while (rs.next()) {
				RecordTime record = new RecordTime();
				//ごはん
				record.setTime(rs.getTimestamp("meal_timestamp"));
				if (rs.getBoolean("milk") == true) {
					record.setWork("ミルク");
					record.setMilk_quantity(rs.getString("milk_quantity") + "ml");
					record.setComment(rs.getString("meal_comment"));
				} else {
					record.setWork("離乳食");
					record.setComment(rs.getString("meal_comment"));
				}
				cardList.add(record);
			}

			//排泄
			sql = "select * from record_excretions "
					+ "where cast(excretion_timestamp as date)= ? AND user_id = ? ";
			pStmt = conn.prepareStatement(sql);

			//SQLを完成させる

			pStmt.setDate(1, date);
			pStmt.setInt(2, user_id);

			// SQL文を実行し、結果表を取得する
			rs = pStmt.executeQuery();

			while (rs.next()) {
				RecordTime record = new RecordTime();
				record.setTime(rs.getTimestamp("excretion_timestamp"));
				if (rs.getBoolean("poop") == true) {
					record.setWork("うんち");
					record.setComment(rs.getString("excretion_comment"));
				} else {
					record.setWork("おしっこ");
					record.setComment(rs.getString("excretion_comment"));
				}
				cardList.add(record);
			}

			sql = "select * from record_sleeps "
					+ "where cast(sleep_timestamp as date) = ? AND user_id = ? ";
			pStmt = conn.prepareStatement(sql);

			//SQLを完成させる

			pStmt.setDate(1, date);
			pStmt.setInt(2, user_id);

			// SQL文を実行し、結果表を取得する
			rs = pStmt.executeQuery();

			while (rs.next()) {
				RecordTime record = new RecordTime();
				record.setTime(rs.getTimestamp("sleep_timestamp"));
				record.setComment(rs.getString("sleep_comment"));
				cardList.add(record);
			}
		}

		catch (SQLException e) {
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

	// 記録書登録
	public boolean insert(Records record) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO Records(id,user_id,date,temperature) "
					+ "VALUES (NULL,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, record.getUser_id());
			pStmt.setDate(2, record.getDate());
			pStmt.setString(3, record.getTemperature());

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

	// 排泄の登録
	public boolean insert1(Record_excretions excretion) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String record_sql = "INSERT INTO Records(id) "
					+ "VALUES (NULL)";
			PreparedStatement record_pStmt = conn.prepareStatement(record_sql);

			// SQL文を実行する
			if (record_pStmt.executeUpdate() == 1) {
				result = true;
			}

			String sql = "INSERT INTO Record_excretions (excretion_id,user_id,excretion_time,excretion_comment,poop,pee,excretion_timestamp) "
					+ "VALUES (NULL,?,?,?,?,?,CURRENT_TIMESTAMP)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, excretion.getUser_id());
			pStmt.setTime(2, excretion.getExcretion_time());
			pStmt.setString(3, excretion.getExcretion_comment());
			pStmt.setBoolean(4, excretion.getPoop());
			pStmt.setBoolean(5, excretion.getPee());

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

	// 食事の登録
	public boolean insert2(Record_meals meals) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する
			String record_sql = "INSERT INTO Records(id) "
					+ "VALUES (NULL)";
			PreparedStatement record_pStmt = conn.prepareStatement(record_sql);

			// SQL文を実行する
			if (record_pStmt.executeUpdate() == 1) {
				result = true;
			}

			String sql = "INSERT INTO Record_meals (meal_id,user_id,meal_time,milk,baby_food,milk_quantity,meal_comment,meal_timestamp) "
					+ "VALUES (NULL,?,?,?,?,?,?,CURRENT_TIMESTAMP)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を実行する
			pStmt.setInt(1, meals.getUser_id());
			pStmt.setTime(2, meals.getMeal_time());
			pStmt.setBoolean(3, meals.getMilk());
			pStmt.setBoolean(4, meals.getBaby_food());
			pStmt.setString(5, meals.getMilk_quantity());
			pStmt.setString(6, meals.getMeal_comment());

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

	//睡眠の登録
	public boolean insert3(Record_sleeps sleeps) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する
			String record_sql = "INSERT INTO Records(id) "
					+ "VALUES (NULL)";
			PreparedStatement record_pStmt = conn.prepareStatement(record_sql);

			// SQL文を実行する
			if (record_pStmt.executeUpdate() == 1) {
				result = true;
			}

			String sql = "INSERT INTO Record_sleeps (sleep_id,user_id,sleep_time,sleep_comment,sleep_timestamp) "
					+ "VALUES (NULL,?,?,?,CURRENT_TIMESTAMP)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を実行する

			pStmt.setInt(1, sleeps.getUser_id());
			pStmt.setTime(2, sleeps.getSleep_time());
			pStmt.setString(3, sleeps.getSleep_comment());

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

	//新規画像登録
	public boolean insert4(UploadFile upload) {

		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO photos (id, user_id,img_timestamp,imgPath1, imgPath2, imgPath3, imgPath4, imgPath5) VALUES (NULL,?,CURRENT_TIMESTAMP,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, upload.getUser_id());
			pStmt.setString(2, upload.getImgPath1());
			pStmt.setString(3, upload.getImgPath2());
			pStmt.setString(4, upload.getImgPath3());
			pStmt.setString(5, upload.getImgPath4());
			pStmt.setString(6, upload.getImgPath5());

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

	public List<UploadFile> photoselect(Date date, int user_id) {
		Connection conn = null;
		List<UploadFile> photoList = new ArrayList<UploadFile>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する
			String sql = "select * from photos "
					+ "where cast(img_timestamp as date) = ? AND user_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setDate(1, date);
			pStmt.setInt(2, user_id);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				UploadFile upho = new UploadFile();
				upho.setImg_timestamp(rs.getTimestamp("img_timestamp"));
				upho.setImgPath1(rs.getString("imgPath1"));
				upho.setImgPath2(rs.getString("imgPath2"));
				upho.setImgPath3(rs.getString("imgPath3"));
				upho.setImgPath4(rs.getString("imgPath4"));
				upho.setImgPath5(rs.getString("imgPath5"));
				photoList.add(upho);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			photoList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			photoList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					photoList = null;
				}

			}
		}
		return photoList;
	}
}
