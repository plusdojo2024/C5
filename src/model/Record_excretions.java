package model;

import java.io.Serializable;
import java.sql.Timestamp;

//フィールドを増やした分だけ、下のコンストラクタを増やす
public class Record_excretions implements Serializable {
	private int record_id;/* 記録書ID */
	private Timestamp excretion_time;/* 排泄時間 */
	private String excretion_comment;/* 備考 */
	private Boolean poop;/* うんち */
	private Boolean pee;/* おしっこ */

	//	引数のあるコンストラクタ
	public Record_excretions(int record_id, Timestamp excretion_time,
			String excretion_comment, Boolean poop, Boolean pee) {

		this.record_id = record_id;
		this.excretion_time = excretion_time;
		this.excretion_comment = excretion_comment;
		this.poop = poop;
		this.pee = pee;

	}

	//	引数のないコンストラクタ
	public Record_excretions() {
		this.record_id = 0;
		this.excretion_time = new Timestamp(System.currentTimeMillis());
		this.excretion_comment = "";
		this.poop = false;
		this.pee = false;
	}

	public int getRecord_id() {
		return record_id;
	}

	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}

	public Timestamp getExcretion_time() {
		return excretion_time;
	}

	public void setExcretion_time(Timestamp excretion_time) {
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
}
