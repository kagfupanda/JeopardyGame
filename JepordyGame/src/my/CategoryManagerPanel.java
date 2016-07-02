package my;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CategoryManagerPanel extends JPanel {

	public CategoryManagerPanel(ArrayList<String> category, ArrayList<String> dollarValues, ScorePanel sp) {
		// set the layout
		int size = dollarValues.size();
		this.setLayout(new GridLayout(1, size));
		
		for(String cat: category) {
			CategoryPanel cp = new CategoryPanel(cat, dollarValues, sp);
			this.add(cp);
		}
	}
}
