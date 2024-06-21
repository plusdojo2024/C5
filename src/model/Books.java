package model;

import java.io.Serializable;

//フィールドを増やした分だけ、下のコンストラクタを増やす
public class Books implements Serializable {
	private int id;/* ブックID */
	private int channel_id;/* チャンネルID */
	private int item_id;/* 項目ID */
	private String explanation;/* 説明 */

	//	引数のあるコンストラクタ
	public Books(int id, int channel_id, int item_id, String explanation) {

		this.id = id;
		this.channel_id = channel_id;
		this.item_id = item_id;
		this.explanation = explanation;

	}

	//	引数のないコンストラクタ
	public Books() {
		this.id = 0;
		this.channel_id = 0;
		this.item_id = 0;
		this.explanation = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
}
