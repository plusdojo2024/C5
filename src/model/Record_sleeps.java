package model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

//フィールドを増やした分だけ、下のコンストラクタを増やす
public class Record_sleeps implements Serializable {
	private int sleep_id;/* 記録書ID */
	private int user_id;
	private Time sleep_time;/* 睡眠時間 */
	private String sleep_comment;/* 備考 */
	private Timestamp sleep_timestamp;

	//	引数のあるコンストラクタ
	public Record_sleeps(int sleep_id,int user_id, Time sleep_time,
			String sleep_comment,Timestamp sleep_timestamp) {

		this.sleep_id = sleep_id;
		this.user_id = user_id;
		this.sleep_time = sleep_time;
		this.sleep_comment = sleep_comment;
		this.sleep_timestamp = sleep_timestamp;

	}

	//	引数のないコンストラクタ
	public Record_sleeps() {
		this.sleep_id = 0;
		this.sleep_comment="";
	}

	public int getSleep_id() {
		return sleep_id;
	}

	public void setSleep_id(int sleep_id) {
		this.sleep_id = sleep_id;
	}

	public Time getSleep_time() {
		return sleep_time;
	}

	public void setSleep_time(Time sleep_time) {
		this.sleep_time = sleep_time;
	}

	public String getSleep_comment() {
		return sleep_comment;
	}

	public void setSleep_comment(String sleep_comment) {
		this.sleep_comment = sleep_comment;
	}

	public Timestamp getSleep_timestamp() {
		return sleep_timestamp;
	}

	public void setSleep_timestamp(Timestamp sleep_timestamp) {
		this.sleep_timestamp = sleep_timestamp;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	}
