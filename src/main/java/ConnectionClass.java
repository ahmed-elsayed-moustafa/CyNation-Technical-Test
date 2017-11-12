import java.sql.*;
import java.util.ArrayList;

public class ConnectionClass {

	private Connection c = null;
	private Statement stmt = null;

	public ConnectionClass() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");
	}

	//list of questions
	public ArrayList<String> selectQuestions() throws SQLException {
		stmt = c.createStatement();
		ArrayList<String> list = new ArrayList<String>();
		String sql = "SELECT question FROM  questions ORDER BY questionno";
		ResultSet r = stmt.executeQuery(sql);
		while (r.next()) {
			list.add(r.getString("question"));
		}
		return list;
	}

	//list of responses
	public ArrayList<String> selectResponses() throws SQLException {
		stmt = c.createStatement();
		ArrayList<String> list = new ArrayList<String>();
		String sql = "SELECT response FROM responses WHERE response IS NOT NULL;";
		ResultSet r = stmt.executeQuery(sql);
		while (r.next()) {
			list.add(r.getString("response"));
		}
		return list;
	}

	//keeping track of answers for each question
	public void saveAnswer(String answer, String question) {

		String sql = "UPDATE questions SET";

		switch (answer) {
		case "YES":
			sql += " answeryes = answeryes + 1";
			break;

		case "NO":
			sql += " answerno = answerno + 1";
			break;
		}
		sql += " WHERE question = '" + question + "'";

		System.out.println(sql);

		try {
			System.out.println(stmt.executeUpdate(sql) + " row updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
