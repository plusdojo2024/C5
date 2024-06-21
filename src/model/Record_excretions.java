package model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

//フィールドを増やした分だけ、下のコンストラクタを増やす
public class Record_excretions implements Serializable {
	private int excretion_id;/* 記録書ID */
	private int user_id;
	private Time excretion_time;/* 排泄時間 */
	private String excretion_comment;/* 備考 */
	private Boolean poop;/* うんち */
	private Boolean pee;/* おしっこ */
	private Timestamp excretion_timestamp;

	//	引数のあるコンストラクタ
	public Record_excretions(int excretion_id,int user_id, Time excretion_time,
			String excretion_comment, Boolean poop, Boolean pee, Timestamp excTimestamp) {

		this.excretion_id = excretion_id;
		this.user_id = user_id;
		this.excretion_time = excretion_time;
		this.excretion_comment = excretion_comment;
		this.poop = poop;
		this.pee = pee;
		this.excretion_timestamp = excTimestamp;

	}

	//	引数のないコンストラクタ
	public Record_excretions() {
		this.excretion_id = 0;
//		this.excretion_time = new Timestamp(System.currentTimeMillis());
		this.excretion_comment = "";
		this.poop = false;
		this.pee = false;
	}

	public int getExcretion_id() {
		return excretion_id;
	}

	public void setExcretion_id(int excretion_id) {
		this.excretion_id = excretion_id;
	}

	public Time getExcretion_time() {
		return excretion_time;
	}

	public void setExcretion_time(Time excretion_time) {
		this.excretion_time = excretion_time;
	}

	public String getExcretion_comment() {
		return excretion_comment;
	}

	public void setExcretion_comment(String excretion_comment) {
		this.excretion_comment = excretion_comment;
	}

	public Boolean getPoop() {
		return poop;
	}

	public void setPoop(Boolean poop) {
		this.poop = poop;
	}

	public Boolean getPee() {
		return pee;
	}

	public void setPee(Boolean pee) {
		this.pee = pee;
	}

	//Stringの配列に一致する文字列があれば、sampleCheckBoxのBooleanをTrueにする
	public void setExcretionCheckBox(String[] values) {
		//一度全部、falseにする。
		this.pee = false;
		this.poop = false;

		if (values == null) {
			return;
		}

		//一致した文字列のフィールドのみ、trueにする
		for(String s : values) {
			switch (s) {
			case "pee":
				this.pee = true;
				break;
			case "poop":
				this.poop = true;
			default:
			}
		}
	}

	public Timestamp getExcretion_timestamp() {
		return excretion_timestamp;
	}

	public void setExcretion_timestamp(Timestamp excretion_timestamp) {
		this.excretion_timestamp = excretion_timestamp;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
