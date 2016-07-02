package my;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;

public class JeapordyGame {
	// did commit
	// made a change - testing git
	
	public static void main(String[] args) {
		ArrayList<String> cats = new ArrayList<>(Arrays.asList("Biogeochemical-Cycles", "Biotic-Or-Abiotic", "Ecological-Restoration", "Population", "Water-Pollution"));
		ArrayList<String> dollarValues = new ArrayList<>(Arrays.asList("100", "200", "300", "400", "500"));
		JFrame jf = new JFrame("JeopardyGame");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ScorePanel sp = new ScorePanel();
		CategoryManagerPanel cmp = new CategoryManagerPanel(cats, dollarValues, sp);
		jf.getContentPane().setLayout(new GridLayout(2, 1));
		jf.getContentPane().add(cmp);
		jf.getContentPane().add(sp);
		jf.setVisible(true);
		jf.pack();
	}

}
