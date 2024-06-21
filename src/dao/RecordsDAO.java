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
	public List<RecordTime> select(Date date) {
		Connection conn = null;
		List<RecordTime> cardList = new ArrayList<RecordTime>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する
			String sql = "select * from records "
					+ "left join users on records.user_id = users.id "
					+ "left join record_meals on records.user_id = record_meals.user_id "
					+ "left join record_sleeps on records.user_id = record_sleeps.user_id "
					+ "left join record_excretions on records.user_id = record_excretions.user_id "
					+ "where date = ? "
					+ "order by records.id ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQLを完成させる

			pStmt.setDate(1, date);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をjavaが扱いやすいコレクション（リスト）に変換する
			while (rs.next()) {
				//	System.out.println(rs.getString("record_id"));
				//				System.out.println(rs.getString("excretion_comment"));
				//				System.out.println("-------------------");

				//RecordTime
				//	time
				//  work
				//  remarks

				RecordTime record = new RecordTime();

				//ごはん
				if (rs.getTimestamp("meal_timestamp") != null) {
					record.setTime(rs.getTimestamp("meal_timestamp"));
					if (rs.getBoolean("milk") == true) {
						record.setWork("ミルク");
						record.setMilk_quantity(rs.getString("milk_quantity") + "ml");
						record.setComment(rs.getString("meal_comment"));
					} else {
						record.setWork("離乳食");
						record.setComment(rs.getString("meal_comment"));
					}
				}

				//排泄
				else if (rs.getTimestamp("excretion_timestamp") != null) {
					record.setTime(rs.getTimestamp("excretion_timestamp"));
					if (rs.getBoolean("poop") == true) {
						record.setWork("うんち");
						record.setComment(rs.getString("excretion_comment"));
					} else {
						record.setWork("おしっこ");
						record.setComment(rs.getString("excretion_comment"));
					}
				}
				//睡眠
				else if (rs.getTimestamp("sleep_timestamp") != null) {
					record.setTime(rs.getTimestamp("sleep_timestamp"));
					record.setComment(rs.getString("sleep_comment"));

				}

				else {
					break;
				}

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

			/*				String sqls = "INSERT INTO Records(user_id) VALUES(?)";
							PreparedStatement pStmts = conn.prepareStatement(sqls);
							Users user = new Users();

							pStmts.setInt(1,record.getUser_id());

							if (pStmts.executeUpdate() == 1) {
								result = true;
							}*/

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
	public boolean insert(UploadFile upload) {

		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C5", "sa", "pw");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO photos (user_id,img_timestamp,imgPath1, imgPath2, imgPath3, imgPath4, imgPath5) VALUES (?,CURRENT_TIMESTAMP,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, upload.getUser_id());
			pStmt.setString(2, upload.getImgPath1());
			pStmt.setString(3, upload.getImgPath2());
			pStmt.setString(4, upload.getImgPath3());
			pStmt.setString(5, upload.getImgPath4());
			pStmt.setString(6, upload.getImgPath5());

			// 登録：SQL文を完成させる
			//				if (upload.getImgPath1() != null && !upload.getImgPath1().equals("")) {
			//					pStmt.setString(1, upload.getImgPath1());
			//				}
			//				if (upload.getImgPath2() != null && !upload.getImgPath2().equals("")) {
			//					pStmt.setString(2, upload.getImgPath2());
			//				}
			//				if (upload.getImgPath3() != null && !upload.getImgPath3().equals("")) {
			//					pStmt.setString(3, upload.getImgPath3());
			//				}
			//				if (upload.getImgPath4() != null && !upload.getImgPath4().equals("")) {
			//					pStmt.setString(4, upload.getImgPath4());
			//				}
			//				if (upload.getImgPath5() != null && !upload.getImgPath5().equals("")) {
			//					pStmt.setString(5, upload.getImgPath5());
			//				}

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
