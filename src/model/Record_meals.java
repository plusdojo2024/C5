package model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

//フィールドを増やした分だけ、下のコンストラクタを増やす
public class Record_meals implements Serializable {
	private int meal_id;/* 記録書ID */
	private int user_id;
	private Time meal_time;/* 食事時間 */
	private Boolean milk;/* ミルク */
	private Boolean baby_food;/* 離乳食 */
	private String milk_quantity;/* ミルク量 */
	private String meal_comment;/* 備考*/
	private Timestamp meal_timestamp;

	//	引数のあるコンストラクタ
	public Record_meals(int meal_id,int user_id, Time meal_time,
			Boolean milk, Boolean baby_food, String milk_quantity, String meal_comment, Timestamp meal_timestamp) {

		this.meal_id = meal_id;
		this.user_id = user_id;
		this.meal_time = meal_time;
		this.milk = milk;
		this.baby_food=baby_food;
		this.milk_quantity = milk_quantity;
		this.meal_comment = meal_comment;
		this.meal_timestamp = meal_timestamp;

	}

	//	引数のないコンストラクタ
	public Record_meals() {
		this.meal_id = 0;
//		this.meal_time="";
		this.milk=false;
		this.baby_food=false;
		this.milk_quantity="";
		this.meal_comment="";
	}

	public int getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(int meal_id) {
		this.meal_id = meal_id;
	}

	public Time getMeal_time() {
		return meal_time;
	}

	public void setMeal_time(Time meal_time) {
		this.meal_time = meal_time;
	}

	public Boolean getMilk() {
		return milk;
	}

	public void setMilk(Boolean milk) {
		this.milk = milk;
	}

	public Boolean getBaby_food() {
		return baby_food;
	}

	public void setBaby_food(Boolean baby_food) {
		this.baby_food = baby_food;
	}

	public String getMilk_quantity() {
		return milk_quantity;
	}

	public void setMilk_quantity(String milk_quantity) {
		this.milk_quantity = milk_quantity;
	}

	public String getMeal_comment() {
		return meal_comment;
	}

	public void setMeal_comment(String meal_comment) {
		this.meal_comment = meal_comment;
	}

	//Stringの配列に一致する文字列があれば、sampleCheckBoxのBooleanをTrueにする
	public void setExcretionCheckBox(String[] values) {
		//一度全部、falseにする。
		this.milk = false;
		this.baby_food = false;

		if (values == null) {
			return;
		}

		//一致した文字列のフィールドのみ、trueにする
		for(String s : values) {
			switch (s) {
			case "milk":
				this.milk = true;
				break;
			case "baby_food":
				this.baby_food = true;
			default:
			}
		}
	}

	public Timestamp getMeal_timestamp() {
		return meal_timestamp;
	}

	public void setMeal_timestamp(Timestamp meal_timestamp) {
		this.meal_timestamp = meal_timestamp;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}

