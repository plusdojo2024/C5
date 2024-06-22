package model;

import java.io.Serializable;
import java.sql.Timestamp;

//フィールドを増やした分だけ、下のコンストラクタを増やす
public class Consuls implements Serializable {
	private int id;
	private int user_id;
	private int channel_id;
	private String consul_content;
	private Timestamp consul_time;

	public Consuls(int id, int user_id, int channel_id, String consul_content, Timestamp consul_time) {
		this.id = id;
		this.user_id = user_id;
		this.channel_id = channel_id;
		this.consul_content = consul_content;
		this.consul_time = consul_time;
	}

	public Consuls() {

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

	public String getConsul_content() {
		return consul_content;
	}

	public void setConsul_content(String consul_content) {
		this.consul_content = consul_content;
	}

	public Timestamp getConsul_time() {
		return consul_time;
	}

	public void setConsul_time(Timestamp consul_time) {
		this.consul_time = consul_time;
	}

}
