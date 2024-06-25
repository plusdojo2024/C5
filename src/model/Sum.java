package model;

public class Sum {
	private int sum;
	private int user_id;

	public Sum(int sum, int user_id) {
		this.sum = sum;
		this.user_id = user_id;
	}

	public Sum() {

	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
