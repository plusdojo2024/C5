package model;

import java.io.Serializable;
import java.sql.Date;

public class Childinfo implements Serializable {
	private int id; /*id*/
    private Date child_birthday; /* 誕生日 */
    private String child_name; /* 子供の名前 */

    public Childinfo(Date child_birthday, String child_name) {
        this.child_birthday = child_birthday;
        this.child_name = child_name;
    }

    public int getId() {
		return id;
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

    // GetterとSetterは省略（必要に応じて追加）
}
