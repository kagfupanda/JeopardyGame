package my;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CategoryPanel extends JPanel {

	public CategoryPanel(String category, ArrayList<String> dollarValues, ScorePanel sp) {
		//create a grid layout
		int size = dollarValues.size();
		this.setLayout(new GridLayout(size + 1, 1));
		
		// create the title panel
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new GridLayout(1,1));
		JButton categoryTitle = new JButton(category);
		categoryTitle.setEnabled(false);
		titlePanel.add(categoryTitle);
		// add it to the main panel
		this.add(titlePanel);
		
		// create the QuestionReader
		QuestionReader qr = new QuestionReader(category, dollarValues, sp);
		for(String dv: dollarValues) {
			this.add(qr.getQuestionPanel(dv));
		}
	}
}
