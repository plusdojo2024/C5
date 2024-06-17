package model;

import java.io.Serializable;
import java.sql.Date;

public class Childinfo implements Serializable {

    private Date child_birthday; /* 誕生日 */
    private String child_name; /* 子供の名前 */

    public Childinfo(Date child_birthday, String child_name) {
        this.child_birthday = child_birthday;
        this.child_name = child_name;
    }

    // GetterとSetterは省略（必要に応じて追加）
}
