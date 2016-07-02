package my;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class TestScorePanel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("Test Score Panel");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ScorePanel sp = new ScorePanel();
		sp.increaseScore("200");
		sp.decreaseScore("50");
		jf.getContentPane().setLayout(new GridLayout(1,1));
		jf.getContentPane().add(sp);
		jf.setVisible(true);
		jf.pack();
	}
}
