package model;

import java.io.Serializable;
import java.sql.Timestamp;

//フィールドを増やした分だけ、下のコンストラクタを増やす
public class Record_times implements Serializable {
	private int id;/* 記録書ID */
	private Timestamp meal_time;/* 食事時間 */
	private Timestamp excretion_time;/* 排泄時間 */
	private Timestamp sleep_time;/* お昼寝時間 */

	//	引数のあるコンストラクタ
	public Record_times(int id, Timestamp meal_time,
			Timestamp excretion_time, Timestamp sleep_time) {

		this.id = id;
		this.meal_time = meal_time;
		this.excretion_time = excretion_time;
		this.sleep_time = sleep_time;

	}

	//	引数のないコンストラクタ
	public Record_times() {
		this.id = 0;
		this.meal_time=new Timestamp(System.currentTimeMillis());
		this.excretion_time=new Timestamp(System.currentTimeMillis());
		this.sleep_time=new Timestamp(System.currentTimeMillis());

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getMeal_time() {
		return meal_time;
	}

	public void setMeal_time(Timestamp meal_time) {
		this.meal_time = meal_time;
	}

	public Timestamp getExcretion_time() {
		return excretion_time;
	}

	public void setExcretion_time(Timestamp excretion_time) {
		this.excretion_time = excretion_time;
	}

	public Timestamp getSleep_time() {
		return sleep_time;
	}

	public void setSleep_time(Timestamp sleep_time) {
		this.sleep_time = sleep_time;
	}

	}
