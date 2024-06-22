package model;

import java.sql.Timestamp;

public class Consul_comment {
	private String consul_content;
	private String comment_content;
	private int id;
	private int consul_id;
	private String consul_name;
	private String comment_name;
	private Timestamp consul_time;
	private Timestamp comment_time;

	public Consul_comment(String consul_content, String comment_content, int id, int consul_id, String consul_name,
			String comment_name,Timestamp consul_time, Timestamp comment_time) {
		this.consul_content = consul_content;
		this.comment_content = comment_content;
		this.id = id;
		this.consul_id = consul_id;
		this.consul_name = consul_name;
		this.comment_name = comment_name;
		this.consul_time = consul_time;
		this.comment_time = comment_time;
	}

	public String getConsul_content() {
		return consul_content;
	}

	public void setConsul_content(String consul_content) {
		this.consul_content = consul_content;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
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

	public Timestamp getConsul_time() {
		return consul_time;
	}

	public void setConsul_time(Timestamp consul_time) {
		this.consul_time = consul_time;
	}

	public Timestamp getComment_time() {
		return comment_time;
	}

	public void setComment_time(Timestamp comment_time) {
		this.comment_time = comment_time;
	}

	public String getConsul_name() {
		return consul_name;
	}

	public void setConsul_name(String consul_name) {
		this.consul_name = consul_name;
	}

	public String getComment_name() {
		return comment_name;
	}

	public void setComment_name(String comment_name) {
		this.comment_name = comment_name;
	}
}
