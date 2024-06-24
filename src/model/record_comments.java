package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class record_comments  implements Serializable {
	private int comment_id;
	private int user_id;
	private String comment;
	private Timestamp comment_timestamp;

	public record_comments(int comment_id, int user_id, String comment, Timestamp comment_timestamp) {
		this.comment_id = comment_id;
		this.user_id = user_id;
		this.comment = comment;
		this.comment_timestamp = comment_timestamp;
	}

	public record_comments() {

	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getComment_timestamp() {
		return comment_timestamp;
	}

	public void setComment_timestamp(Timestamp comment_timestamp) {
		this.comment_timestamp = comment_timestamp;
	}

}
