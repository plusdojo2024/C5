package model;

import java.io.Serializable;

//フィールドを増やした分だけ、下のコンストラクタを増やす
public class Channels implements Serializable {
	private int id;/* チャンネルID */
	private String channel_name;/* チャンネル名 */

	//	引数のあるコンストラクタ
	public Channels(int id, String channel_name){


		this.id = id;
		this.channel_name = channel_name;
	}

	//	引数のないコンストラクタ
	public Channels() {
		this.id = 0;
		this.channel_name = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChannel_name() {
		return channel_name;
	}

	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}
}