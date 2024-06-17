package model;
import java.io.Serializable;

public class Userpw implements Serializable {
	private String user_name;	// ID
	private String pw;	// PW

	public Userpw(String user_name, String pw) {
		this.user_name = user_name;
		this.pw = pw;
	}

	public Userpw() {
		this.user_name = "";
		this.pw = "";
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return pw;
	}

	public void setPassword(String pw) {
		this.pw = pw;
	}
}
