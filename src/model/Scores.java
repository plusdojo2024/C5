package model;

public class Scores {
	private int id;
	private int user_id;
	private int score;

	//引数あり
	public Scores(int id, int user_id, int score) {
		this.id = id;
		this.user_id = user_id;
		this.score = score;
	}

	//引数なし
	public Scores() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
