package model;

import java.io.Serializable;
import java.util.Date;

//フィールドを増やした分だけ、下のコンストラクタを増やす
public class Records implements Serializable {
	private int id;/* 記録書ID */
	private int user_id; /* ユーザーID */
	private String photo;/* 写真 */
	private Date date; /* 日付 */
	private String temperature;/* 体温 */
	private String comment; /* 自由欄 */

	//	引数のあるコンストラクタ
	public Records(int id, int user_id, String photo,
			Date date, String temperature, String comment) {

		this.id = id;
		this.user_id = user_id;
		this.photo = photo;
		this.date = date;
		this.temperature = temperature;
		this.comment = comment;

	}

	//	引数のないコンストラクタ
	public Records() {
		this.id = 0;
		this.user_id = 0;
		this.photo="";
		this.date=new Date();
		this.temperature="";
		this.comment="";


	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
