package my;

import java.util.ArrayList;

public class QuestionUnit {

	private String dollarValue;
	private String questionText;
	private ArrayList<String> answerText = new ArrayList<>();
	private int correctAnswer;

	public String getDollarValue() {
		return dollarValue;
	}

	public void setDollarValue(String dollarValue) {
		this.dollarValue = dollarValue;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public ArrayList<String> getAnswerText() {
		return answerText;
	}

	public void setAnswerText(ArrayList<String> answerText) {
		this.answerText = answerText;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
}
