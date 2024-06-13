package model;

import java.io.Serializable;

//フィールドを増やした分だけ、下のコンストラクタを増やす
public class Games implements Serializable {
	private int id;/* ゲームID */
	private String quiz;/* 問題 */
	private String choice_1;/* 選択肢１ */
	private String choice_2;/* 選択肢２ */
	private String choice_3;/* 選択肢３ */
	private String choice_4;/* 選択肢４ */
	private String correct; /* 正解 */
	private int score;/* 得点 */

	//	引数のあるコンストラクタ
	public Games(int id, String quiz, String choice_1,
			String choice_2, String choice_3, String choice_4, String correct, int score) {

		this.id = id;
		this.quiz = quiz;
		this.choice_1 = choice_1;
		this.choice_2 = choice_2;
		this.choice_3 = choice_3;
		this.choice_4 = choice_4;
		this.correct = correct;
		this.score = score;

	}

	//	引数のないコンストラクタ
	public Games() {
		this.id = 0;
		this.quiz = "";
		this.choice_1 = "";
		this.choice_2 = "";
		this.choice_3 = "";
		this.choice_4 = "";
		this.correct = "";
		this.score = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuiz() {
		return quiz;
	}

	public void setQuiz(String quiz) {
		this.quiz = quiz;
	}

	public String getChoice_1() {
		return choice_1;
	}

	public void setChoice_1(String choice_1) {
		this.choice_1 = choice_1;
	}

	public String getChoice_2() {
		return choice_2;
	}

	public void setChoice_2(String choice_2) {
		this.choice_2 = choice_2;
	}

	public String getChoice_3() {
		return choice_3;
	}

	public void setChoice_3(String choice_3) {
		this.choice_3 = choice_3;
	}

	public String getChoice_4() {
		return choice_4;
	}

	public void setChoice_4(String choice_4) {
		this.choice_4 = choice_4;
	}

	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	}
