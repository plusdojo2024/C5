package model;
import java.io.Serializable;

public class Userpw implements Serializable {
	private String user_name;	// ID
	private String password;	// PW

	public Userpw(String user_name, String password) {
		this.user_name = user_name;
		this.password = password;
	}

	public Userpw() {
		this.user_name = "";
		this.password = "";
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
