package model;

import java.io.Serializable;

//フィールドを増やした分だけ、下のコンストラクタを増やす
public class Books implements Serializable {
	private int id;/* ブックID */
	private int channel_id;/* チャンネルID */
	private int item_id;/* 項目ID */
	private String item_name;/* 項目名 */
	private String item_icon;/* 項目アイコン */
	private String explanation;/* 説明 */

	//	引数のあるコンストラクタ
	public Books(int id, int channel_id, int item_id,String item_name,String item_icon, String explanation) {

		this.id = id;
		this.channel_id = channel_id;
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_icon = item_icon;
		this.explanation = explanation;

	}

//	public Books(int id, int channel_id, int item_id, String item_name,String explanation) {
//
//		this.id = id;
//		this.channel_id = channel_id;
//		this.item_id = item_id;
//		this.item_name = item_name;
//		this.explanation = explanation;
//
//	}

	//	引数のないコンストラクタ
	public Books() {
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

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_icon() {
		return item_icon;
	}

	public void setItem_icon(String item_icon) {
		this.item_icon = item_icon;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
}
