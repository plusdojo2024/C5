package model;

import java.io.Serializable;
import java.sql.Date;

//フィールドを増やした分だけ、下のコンストラクタを増やす
public class Users implements Serializable {

	private int id;/* ユーザーID */
	private String user_name; /* ユーザー名 */
	private String password; /* パスワード */
	private int sum; /* 合計 */
	private Date child_birthday; /* 誕生日 */
	private String child_name; /* 子供の名前 */

	//	引数のあるコンストラクタ
	public Users(int id, String user_name, String password, int sum,
			Date child_birthday, String child_name) {

		this.id = id;
		this.user_name = user_name;
		this.password = password;
		this.sum = sum;
		this.child_birthday = child_birthday;
		this.child_name = child_name;
	}

	//	引数のないコンストラクタ
	public Users() {
//		this.id = 0;
//		this.user_name = "";
//		this.password = "";
//		this.sum = 0;
//		this.child_birthday = ;
//		this.child_name = "";

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public Date getChild_birthday() {
		return child_birthday;
	}

	public void setChild_birthday(Date child_birthday) {
		this.child_birthday = child_birthday;
	}

	public String getChild_name() {
		return child_name;
	}

	public void setChild_name(String child_name) {
		this.child_name = child_name;
	}
}
