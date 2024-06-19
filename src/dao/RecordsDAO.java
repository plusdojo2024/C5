package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RecordTime;
public class RecordsDAO {
	// 記録書に指定の日付の時間データを表示する
	public List<RecordTime> select(RecordTime card) {
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
					+"left join record_times on  records.id = record_times.record_id "
					+"left join record_meals on records.id = record_meals.record_id "
					+"left join record_sleeps on records.id = record_sleeps.record_id "
					+"left join record_excretions on records.id = record_excretions.record_id "
					+"order by records.id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

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
				if( rs.getTimestamp("meal_time") != null ) {
					record.setTime( rs.getTimestamp("meal_time") );
					if( rs.getBoolean("milk") == true ) {
						record.setWork("ミルク");
						record.setMilk_quantity(rs.getString("milk_quantity"));
						record.setComment(rs.getString("meal_comment"));
					}else {
						record.setWork("離乳食");
						record.setComment(rs.getString("meal_comment"));
					}
				}

				//排泄
				else if(rs.getTimestamp("excretion_time") != null) {
					record.setTime( rs.getTimestamp("excretion_time") );
					if( rs.getBoolean("poop") == true ) {
						record.setWork("うんち");
						record.setComment(rs.getString("excretion_comment"));
					}else {
						record.setWork("おしっこ");
						record.setComment(rs.getString("excretion_comment"));
					}
				}
				//睡眠
				else if(rs.getTimestamp("sleep_time") != null) {
					record.setTime(rs.getTimestamp("sleep_time"));
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
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
	finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}

			}
	}

		// 結果を返す
		return cardList;
	}
}

