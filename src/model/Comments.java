package model;

import java.sql.Timestamp;

public class Comments {
	private int id;
	private int user_id;
	private int consul_id;
	private String comment_content;
	private Timestamp comment_time;

	public Comments(int id, int user_id, int consul_id, String comment_content, Timestamp comment_time) {
		this.id = id;
		this.user_id = user_id;
		this.consul_id = consul_id;
		this.comment_content = comment_content;
		this.comment_time = comment_time;
	}

	public Comments() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getConsul_id() {
		return consul_id;
	}

	public void setConsul_id(int consul_id) {
		this.consul_id = consul_id;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public Timestamp getComment_time() {
		return comment_time;
	}

	public void setComment_time(Timestamp comment_time) {
		this.comment_time = comment_time;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
