package my;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;

public class TestQuestionReader {

	public static void main(String[] args) {
		// initialize dollar values
		ArrayList<String> dvList = new ArrayList<>(Arrays.asList("100", "200", "300", "400", "500"));
		QuestionReader qr = new QuestionReader("sports", dvList);
		JFrame jf = new JFrame("QuestionReader Test");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//System.out.println(qr.getQpList().size());
		//int qpSize = qr.getQpList().size();
		jf.getContentPane().setLayout(new GridLayout(5, 1));
		jf.getContentPane().add(qr.getQuestionPanel("100"));
		jf.getContentPane().add(qr.getQuestionPanel("200"));
		jf.getContentPane().add(qr.getQuestionPanel("300"));
		jf.getContentPane().add(qr.getQuestionPanel("400"));
		jf.getContentPane().add(qr.getQuestionPanel("500"));
		jf.setVisible(true);
		jf.pack();

	}

}
