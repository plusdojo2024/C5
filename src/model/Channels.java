package model;

import java.io.Serializable;

//フィールドを増やした分だけ、下のコンストラクタを増やす
public class Channels implements Serializable {
	private int id;/* チャンネルID */
	private String channel_name;/* チャンネル名 */
	private String channel_color;/* カラー */

	//	引数のあるコンストラクタ
	public Channels(int id, String channel_name, String channel_color){


		this.id = id;
		this.channel_name = channel_name;
		this.channel_color = channel_color;

	}

	//	引数のないコンストラクタ
	public Channels() {
		this.id = 0;
		this.channel_name = "";
		this.channel_color = "";
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

	public String getChannel_color() {
		return channel_color;
	}

	public void setChannel_color(String channel_color) {
		this.channel_color = channel_color;
	}
}