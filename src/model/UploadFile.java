package model;

import java.sql.Timestamp;

/**
 * {@link UploadFile}
 */
public class UploadFile {

	/** 画像パス */
	private int id;
	private int user_id;
	private Timestamp img_timestamp;
	private String imgPath1;
	private String imgPath2;
	private String imgPath3;
	private String imgPath4;
	private String imgPath5;
	/**
	 * コンストラクタ
	 */
	public UploadFile() {

	}

	/**
	 * コンストラクタ
	 * @param imgPath 画像パス
	 */
	public UploadFile(int user_id,Timestamp img_timestamp,String imgPath1, String imgPath2,String imgPath3,String imgPath4,String imgPath5) {
		this.user_id = user_id;
		this.img_timestamp = img_timestamp;
		this.imgPath1 = imgPath1;
		this.imgPath2 = imgPath2;
		this.imgPath3 = imgPath3;
		this.imgPath4 = imgPath4;
		this.imgPath5 = imgPath5;
	}

	/**
	 * @return imgPath
	 */
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Timestamp getImg_timestamp() {
		return img_timestamp;
	}

	public void setImg_timestamp(Timestamp img_timestamp) {
		this.img_timestamp = img_timestamp;
	}

	public String getImgPath1() {
		return imgPath1;
	}

	public void setImgPath1(String imgPath1) {
		this.imgPath1 = imgPath1;
	}

	public String getImgPath2() {
		return imgPath2;
	}

	public void setImgPath2(String imgPath2) {
		this.imgPath2 = imgPath2;
	}

	public String getImgPath3() {
		return imgPath3;
	}

	public void setImgPath3(String imgPath3) {
		this.imgPath3 = imgPath3;
	}

	public String getImgPath4() {
		return imgPath4;
	}

	public void setImgPath4(String imgPath4) {
		this.imgPath4 = imgPath4;
	}

	public String getImgPath5() {
		return imgPath5;
	}

	public void setImgPath5(String imgPath5) {
		this.imgPath5 = imgPath5;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}