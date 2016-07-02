package my;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class QuestionPanel extends JPanel implements ActionListener{
	private String dollarValue;
	private JButton dollarValueButton;
	private String questionText;
	private JTextArea questionTextArea;
	private ArrayList<String> answerText = new ArrayList<>();
	private ArrayList<JButton> answerButton = new ArrayList<>();
	private int correctAnswer;
	final int WIDTH = 200;
	final int HEIGHT = 200;
	final private Dimension size = new Dimension(WIDTH, HEIGHT);
	private ScorePanel sp;
	
	public QuestionPanel(QuestionUnit qu, ScorePanel sp) {
		this(qu.getDollarValue(), qu.getQuestionText(), qu.getAnswerText(), qu.getCorrectAnswer());
		this.sp = sp;
	}

	public QuestionPanel(String dollarValue, String questionText, ArrayList<String> answerText, int correctAnswer) {
		// initialize the private data members using the ctor input arguements. 
		this.dollarValue = dollarValue;
		this.questionText = questionText;
		this.answerText.addAll(answerText);
		this.correctAnswer = correctAnswer;

		//create buttons
		dollarValueButton = new JButton(this.dollarValue);

		//answerbuttons
		for(String s: answerText) {
			answerButton.add(new JButton(s)); 
		}

		//question text area
		questionTextArea = new JTextArea(questionText);
		questionTextArea.setEditable(false);
		questionTextArea.setLineWrap(true);

		//set initial layout
		setLayout(new GridLayout(1,1));

		//add dollar button to layout
		add(dollarValueButton);

		// set up button action listener
		dollarValueButton.addActionListener(this);
		for(JButton b: answerButton) {
			b.addActionListener(this);
		}
		
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return this.size;
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#getMinimumSize()
	 */
	@Override
	public Dimension getMinimumSize() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// print a debug console message
		System.out.printf("DEBUGG: actionPerformed %s%n", e.toString());
		if(e.getSource().equals(dollarValueButton)) {
			System.out.printf("DEBUGG: dollar pressed");
			setLayout(new GridLayout(4, 1));
			remove(dollarValueButton);
			add(questionTextArea);
			for(JButton b: answerButton) {
				add(b);
			}
			revalidate();
		} else { //assuming question side is showing
			if(e.getSource().equals(answerButton.get(correctAnswer))) 
				sp.increaseScore(dollarValue);
			else
				sp.decreaseScore(dollarValue);
			answerButton.get(correctAnswer).setEnabled(true);
			for(JButton b : answerButton) {
				b.removeActionListener(this);
				if(!b.equals(answerButton.get(correctAnswer))) {
					b.setEnabled(false);
				}
			}
			// TODO call score keeper with dollar value
		}
	}

}
