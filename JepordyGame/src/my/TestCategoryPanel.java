package my;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;

public class TestCategoryPanel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> cats = new ArrayList<>(Arrays.asList("sports", "math"));
		ArrayList<String> dollarValues = new ArrayList<>(Arrays.asList("100", "200", "300", "400", "500"));
		JFrame jf = new JFrame("Test Category Manager");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CategoryManagerPanel cmp = new CategoryManagerPanel(cats, dollarValues);
		jf.getContentPane().setLayout(new GridLayout(1,1));
		jf.getContentPane().add(cmp);
		jf.setVisible(true);
		jf.pack();

	}

}
