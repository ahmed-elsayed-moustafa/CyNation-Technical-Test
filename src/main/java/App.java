import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * database connection error encapulsation interfaces write comments packages ->
 * rename
 *
 * @author Ahmed
 */

public class App extends JFrame implements Runnable, IApp {

	private static final long serialVersionUID = 1L;
	private ConnectionClass connection;
	private QuestionPanel[] questions;
	private ResponsePanel[] responses;
	private MappingPanel mapping;
	private ResponsePanel current = null;

	public App(String name) throws ClassNotFoundException, SQLException {
		super(name);
		connection = new ConnectionClass();
		questions = setQuestions();
		responses = setResponses();
		current = questions[0];
		mapping = new MappingPanel(questions, responses);
		this.getContentPane().add(current, null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(360, 250);
		this.setResizable(false);
		new Thread(this).start();
	}

	public QuestionPanel[] getQuestions() {
		return questions;
	}

	public ResponsePanel[] getResponses() {
		return responses;
	}

	public QuestionPanel[] setQuestions() throws SQLException {
		ArrayList<String> questionlist = connection.selectQuestions();
		QuestionPanel[] questions = new QuestionPanel[questionlist.size()];

		for (int i = 0; i < questionlist.size(); i++) {
			QuestionPanel q = new QuestionPanel(questionlist.get(i));
			questions[i] = q;
		}
		return questions;
	}

	public ResponsePanel[] setResponses() throws SQLException {
		ArrayList<String> responselist = connection.selectResponses();
		ResponsePanel[] ResponsePanel = new ResponsePanel[responselist.size()];

		for (int i = 0; i < responselist.size(); i++) {
			ResponsePanel r = new ResponsePanel(responselist.get(i));
			r.setFlag(false);
			ResponsePanel[i] = r;
		}
		return ResponsePanel;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		App a = new App("cyNation App");
	}

	public void selectionAlgorithm(String answer) {
		ResponsePanel panel = mapping.getResponseMap().get(current.getQuestion()).get(answer);	
		setPanelAndValidate(panel);
	}

	public void setPanelAndValidate(ResponsePanel res) {
		setContentPane(res);
		invalidate();
		validate();
		current = res;
	}

	@Override
	public void run() {
		while (true)
			if (current.getFlag()) {
				connection.saveAnswer(current.getSelection(), current.getQuestion());
				selectionAlgorithm(current.getSelection());
			}
	}
}
