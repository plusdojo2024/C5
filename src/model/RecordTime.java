package model;

import java.io.Serializable;
import java.sql.Timestamp;
<<<<<<< HEAD
=======
import java.text.SimpleDateFormat;
import java.util.Date;

>>>>>>> 096450f686fb3ac6feeb1c2e4ff4cb790c82599b

public class RecordTime implements Serializable {
	private Timestamp time; /*記録書時間*/
	private String work;/*ミルク、離乳食、うんち、おしっこ*/
	private String milk_quantity;/*ミルク量*/
	private String comment;/*コメント*/

<<<<<<< HEAD
	//引数のあるコンストラクタ
	public RecordTime(Timestamp time, String work, String milk_quantity, String comment) {
=======
	private Date date;

	//引数のあるコンストラクタ
	public RecordTime(Timestamp time, String work, String milk_quantity, String comment, Date date) {
>>>>>>> 096450f686fb3ac6feeb1c2e4ff4cb790c82599b
		this.time = time;
		this.work = work;
		this.milk_quantity = milk_quantity;
		this.comment = comment;
<<<<<<< HEAD
=======
		this.date = date;
>>>>>>> 096450f686fb3ac6feeb1c2e4ff4cb790c82599b
	}

	//引数のないコンストラクタ
	public RecordTime() {

	}

	//ゲッター・セッター

	public Timestamp getTime() {
		return time;
	}

<<<<<<< HEAD
=======
	//smapleDate用で"yyyy年MM月dd日"へのフォーマット処理を行うgetter
	public String getTimeFormat() {
		if (this.time == null) {
			return "";
		}

	//2024-05-30　から　2024年05月30日へのフォーマット変換
		SimpleDateFormat f = new SimpleDateFormat("HH:mm");
		return f.format(this.time);
		}


>>>>>>> 096450f686fb3ac6feeb1c2e4ff4cb790c82599b
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

<<<<<<< HEAD
=======
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

>>>>>>> 096450f686fb3ac6feeb1c2e4ff4cb790c82599b

}