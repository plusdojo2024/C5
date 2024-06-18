package model;

import java.io.Serializable;
import java.sql.Timestamp;

//フィールドを増やした分だけ、下のコンストラクタを増やす
public class Consuls implements Serializable {

	private int id;/* 相談ID */
	private int user_id;/* ユーザーID */
	private int channel_id;/* チャンネルID */
	private int post_id;/* 投稿ID */
	private int post_number;/* 投稿NO */
	private String post_content;/* 投稿内容 */
	private Timestamp post_time;/* 投稿時間 */

	//	引数のあるコンストラクタ
	public Consuls(int id, int user_id, int channel_id, int post_id,
			int post_number, String post_content, Timestamp post_time) {

		this.id = id;
		this.user_id = user_id;
		this.channel_id = channel_id;
		this.post_id = post_id;
		this.post_number = post_number;
		this.post_content = post_content;
		this.post_time = post_time;

	}

	//	引数のないコンストラクタ
	public Consuls() {
		this.id = 0;
		this.user_id = 0;
		this.channel_id = 0;
		this.post_id = 0;
		this.post_number = 0;
		this.post_content = "";
		this.post_time = new Timestamp(System.currentTimeMillis());
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

	public int getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getPost_number() {
		return post_number;
	}

	public void setPost_number(int post_number) {
		this.post_number = post_number;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public Timestamp getPost_time() {
		return post_time;
	}

	public void setPost_time(Timestamp post_time) {
		this.post_time = post_time;
	}
}
