import java.util.HashMap;

public class MappingPanel {

	private HashMap<String, HashMap<String, ResponsePanel>> responseMap = new HashMap<String, HashMap<String, ResponsePanel>>();

	private ResponsePanel[] questions, responses;

	public MappingPanel(ResponsePanel[] questions, ResponsePanel[] responses) {
		this.questions = questions;
		this.responses = responses;
		firstQuestion();
		secondQuestion();
		thirdQuestion();
		fourthQuestion();
		fifthQuestion();
		sixthQuestion();
	}
	
	public void firstQuestion() {
		HashMap<String, ResponsePanel> first = new HashMap<String, ResponsePanel>();
		first.put("YES", questions[1]);
		first.put("NO", questions[4]);
		responseMap.put("IS YOUR COMPANY IN EUROPE?", first);
	}

	public void secondQuestion() {
		HashMap<String, ResponsePanel> second = new HashMap<String, ResponsePanel>();
		second.put("YES", questions[2]);
		second.put("NO", responses[0]);
		responseMap.put("IS YOUR DATA FROM THE EU?", second);
	}

	public void thirdQuestion() {
		HashMap<String, ResponsePanel> third = new HashMap<String, ResponsePanel>();
		third.put("YES", questions[3]);
		third.put("NO", responses[0]);
		responseMap.put("DO YOU STORE YOUR DATA IN EUROPE?", third);
	}

	public void fourthQuestion() {
		HashMap<String, ResponsePanel> fourth = new HashMap<String, ResponsePanel>();
		fourth.put("YES", responses[1]);
		fourth.put("NO", questions[5]);
		responseMap.put("DO YOU OWN THE STORAGE OR OUTSOURCE?", fourth);
	}

	public void fifthQuestion() {
		HashMap<String, ResponsePanel> fourth = new HashMap<String, ResponsePanel>();
		fourth.put("YES", questions[2]);
		fourth.put("NO", responses[0]);
		responseMap.put("DO YOU SELL IN EU?", fourth);
	}

	public void sixthQuestion() {
		HashMap<String, ResponsePanel> fourth = new HashMap<String, ResponsePanel>();
		fourth.put("YES", responses[1]);
		fourth.put("NO", responses[0]);
		responseMap.put("DOES YOUR OUTSOURCE EXIST IN EUROPE?", fourth);
	}

	public HashMap<String, HashMap<String, ResponsePanel>> getResponseMap() {
		return responseMap;
	}
}
