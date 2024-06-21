package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RecordTime implements Serializable {
	private Timestamp time; /*記録書時間*/
	private String work;/*ミルク、離乳食、うんち、おしっこ*/
	private String milk_quantity;/*ミルク量*/
	private String comment;/*コメント*/

	private Date date;

	//引数のあるコンストラクタ
	public RecordTime(Timestamp time, String work, String milk_quantity, String comment, Date date) {
		this.time = time;
		this.work = work;
		this.milk_quantity = milk_quantity;
		this.comment = comment;
		this.date = date;
	}

	//引数のないコンストラクタ
	public RecordTime() {

	}

	//ゲッター・セッター

	public Timestamp getTime() {
		return time;
	}

	//smapleDate用で"yyyy年MM月dd日"へのフォーマット処理を行うgetter
	public String getTimeFormat() {
		if (this.time == null) {
			return "";
		}

	//2024-05-30　から　2024年05月30日へのフォーマット変換
		SimpleDateFormat f = new SimpleDateFormat("HH:mm");
		return f.format(this.time);
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


}