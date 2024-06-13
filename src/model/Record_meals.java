package model;

import java.io.Serializable;
import java.sql.Timestamp;

//フィールドを増やした分だけ、下のコンストラクタを増やす
public class Record_meals implements Serializable {
	private int record_id;/* 記録書ID */
	private Timestamp meal_time;/* 食事時間 */
	private Boolean milk;/* ミルク */
	private Boolean baby_food;/* 離乳食 */
	private String milk_quantity;/* ミルク量 */
	private String meal_comment;/* 備考*/

	//	引数のあるコンストラクタ
	public Record_meals(int record_id, Timestamp meal_time,
			Boolean milk, Boolean baby_food, String milk_quantity, String meal_comment) {

		this.record_id = record_id;
		this.meal_time = meal_time;
		this.milk = milk;
		this.baby_food=baby_food;
		this.milk_quantity = milk_quantity;
		this.meal_comment = meal_comment;

	}

	//	引数のないコンストラクタ
	public Record_meals() {
		this.record_id = 0;
		this.meal_time=new Timestamp(System.currentTimeMillis());
		this.milk=false;
		this.baby_food=false;
		this.milk_quantity="";
		this.meal_comment="";
	}

	public int getRecord_id() {
		return record_id;
	}

	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}

	public Timestamp getMeal_time() {
		return meal_time;
	}

	public void setMeal_time(Timestamp meal_time) {
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
	}
