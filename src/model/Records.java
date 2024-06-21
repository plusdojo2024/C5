package model;

import java.io.Serializable;
import java.sql.Date;

//フィールドを増やした分だけ、下のコンストラクタを増やす
public class Records implements Serializable {
	private int id;/* 記録書ID */
	private int user_id; /* ユーザーID */
	private String temperature;/* 体温 */
	private Date date;

	//	引数のあるコンストラクタ
	public Records(int id, int user_id,
			String temperature,String records_comment,Date date) {

		this.id = id;
		this.user_id = user_id;
		this.temperature = temperature;
		this.date = date;

	}

	//	引数のないコンストラクタ
	public Records() {
		this.id = 0;
		this.user_id = 0;
		this.temperature = "";
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

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


}
