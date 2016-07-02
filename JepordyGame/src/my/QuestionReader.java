package my;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class QuestionReader {
	private HashMap<String, ArrayList<QuestionPanel>> qpMap = new HashMap<>();

	/**
	 * @return the qpList
	 */

	public QuestionReader(String category, ArrayList<String> dollarValues, ScorePanel sp) {
		// create a filename and read the question units
		for (String dv : dollarValues) {
			ArrayList<QuestionPanel> qpList = new ArrayList<>();
			StringBuilder sb = new StringBuilder(category);
			sb.append(".");
			sb.append(dv);
			sb.append(".questions.txt");
			String filename = sb.toString();
			//create a path
			//Path qfile = Paths.get(System.getProperty("user.home"), filename);
			// reading from jar file now
			ClassLoader cLoader = this.getClass().getClassLoader();
			//create an input filestream to read resource's files
			//find the file we want in the resource folder included in the jar file
			InputStream inpStr = cLoader.getResourceAsStream(filename);

			try (/*BufferedReader reader = Files.newBufferedReader(qfile)*/
					BufferedReader reader = new BufferedReader(new InputStreamReader(inpStr))) {
				String qline;
				ArrayList<String> ans = new ArrayList<>();
				while  ((qline = reader.readLine()) != null) { // read the question
					//read the answers and choice
					for(int i = 0; i < 3; i++) //read next 3 lines
						ans.add(reader.readLine());
					String cans = reader.readLine(); // read correct choice
					QuestionUnit qu = new QuestionUnit();
					qu.setDollarValue(dv);
					qu.setQuestionText(qline);
					qu.setAnswerText(ans);
					qu.setCorrectAnswer(Integer.parseInt(cans));
					qpList.add(new QuestionPanel(qu, sp));
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			// add and entry into the map
			qpMap.put(dv, qpList);
		}
	}
	
	public QuestionPanel getQuestionPanel(String dollarValue) {
		ArrayList<QuestionPanel> qpList = qpMap.get(dollarValue);
		int size = qpList.size();
		System.out.println(size);
		Random random = new Random();
		int selectIndex = random.nextInt(size - 1);
		return qpList.get(selectIndex);
	}
}
