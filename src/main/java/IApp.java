import java.sql.SQLException;

public interface IApp {

	/**
	 * This method retrieves all the questions from the database and creates the
	 * Panel for each.
	 * 
	 * Intended purpose is to use the questionPanel array to identify the the next
	 * auestion which will be asked based on the specification given by shadi.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public QuestionPanel[] setQuestions() throws SQLException;

	/**
	 * This method retrieves all the responses from the database and creates the
	 * Panel for each.
	 * 
	 * Intended purpose is to use the responsePanel which will be the end result
	 * given a sequence of questions.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ResponsePanel[] setResponses() throws SQLException;

	/**
	 * 
	 * Based on the selection we need to identify the right question to ask next
	 *
	 * This is done via Mapping the question to the next based on the answer
	 *
	 * @param answer
	 */
	public void selectionAlgorithm(String answer);

	
	/**
	 * 
	 * Changes the panel to the next specified JPanel and updates the view and keeps track of the current view
	 * 
	 * @param res
	 */
	public void setPanelAndValidate(ResponsePanel res);

	/**
	 * Based on selection we need to keep track of the current View
	 * 
	 */
	public void updateIndexBasedOnYes();

	
	/**
	 * Based on selection we need to keep track of the current View
	 * 
	 */
	public void updateIndexBasedOnNo();

}
