package my;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScorePanel extends JPanel {
	private int currentScore = 0;
	private JTextField score;
	private JTextField scoreNum;

	public ScorePanel() {
		// create a text area and add it to the panel
		this.setLayout(new GridLayout(1, 2));
		
		score = new JTextField("Score: ");
		score.setEnabled(false);
		scoreNum = new JTextField("" + currentScore);
		scoreNum.setEditable(false);
		
		// add text fields to panel
		this.add(score);
		this.add(scoreNum);
		
	}

	public void increaseScore(String dollarValue) {
		// convert string to int, update current score, and post it in the panel
		currentScore = Integer.parseInt(dollarValue) + currentScore;
		scoreNum.setText("" + currentScore);
		System.out.println(currentScore);
	}
	
	public void decreaseScore(String dollarValue) {
		// convert string to int, update current score, and post it in the panel
		currentScore = currentScore - Integer.parseInt(dollarValue);
		scoreNum.setText("" + currentScore);
		System.out.println(currentScore);
	}
	
}
