package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class RecordTime implements Serializable {
	private Timestamp time; /*記録書時間*/
	private String work;/*ミルク、離乳食、うんち、おしっこ*/
	private String milk_quantity;/*ミルク量*/
	private String comment;/*コメント*/

	//引数のあるコンストラクタ
	public RecordTime(Timestamp time, String work, String milk_quantity, String comment) {
		this.time = time;
		this.work = work;
		this.milk_quantity = milk_quantity;
		this.comment = comment;
	}

	//引数のないコンストラクタ
	public RecordTime() {

	}

	//ゲッター・セッター

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getMilk_quantity() {
		return milk_quantity;
	}

	public void setMilk_quantity(String milk_quantity) {
		this.milk_quantity = milk_quantity;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


}