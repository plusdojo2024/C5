package model;

import java.io.Serializable;
import java.sql.Timestamp;

//フィールドを増やした分だけ、下のコンストラクタを増やす
public class Record_sleeps implements Serializable {
	private int record_id;/* 記録書ID */
	private Timestamp sleep_time;/* 睡眠時間 */
	private String sleep_comment;/* 備考 */

	//	引数のあるコンストラクタ
	public Record_sleeps(int record_id, Timestamp sleep_time,
			String sleep_comment) {

		this.record_id = record_id;
		this.sleep_time = sleep_time;
		this.sleep_comment = sleep_comment;

	}

	//	引数のないコンストラクタ
	public Record_sleeps() {
		this.record_id = 0;
		this.sleep_time=new Timestamp(System.currentTimeMillis());
		this.sleep_comment="";
	}


	public int getRecord_id() {
		return record_id;
	}

	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}

	public Timestamp getSleep_time() {
		return sleep_time;
	}

	public void setSleep_time(Timestamp sleep_time) {
		this.sleep_time = sleep_time;
	}

	public String getSleep_comment() {
		return sleep_comment;
	}

	public void setSleep_comment(String sleep_comment) {
		this.sleep_comment = sleep_comment;
	}

	}
