package my;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;

public class TestQuestionPanel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("Test Question Panel");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create a question panel
		ArrayList<String> answers = new ArrayList<>(Arrays.asList("Answer 1", "Answer 2", "Answer 3"));
		String question = "What is your answer?";
		String dollar = "$100";
		QuestionPanel qp = new QuestionPanel(dollar, question, answers, 0);
		
		//add panel to frame
		jf.getContentPane().add(qp);
		jf.setVisible(true);
		jf.pack();

	}

}
