import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ResponsePanel extends JPanel {

	private JLabel label;
	private String question;
	private volatile boolean flag = false;
	private String selection = "";

	//added the components 
	ResponsePanel(String question) {
		this.question = question;
		this.setLayout(new BorderLayout());
		this.add(new JLabel(resize()), BorderLayout.NORTH);
		this.add(new JLabel(" " + question, SwingUtilities.CENTER), BorderLayout.CENTER);
	}

	//cynation logo downloaded and resized to fit app
	public ImageIcon resize() {
		ImageIcon iconLogo = new ImageIcon(this.getClass().getResource("/logo.jpg"));
		Image image = iconLogo.getImage(); // transform it
		Image newimg = image.getScaledInstance(318, 100, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(newimg);
	}

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getQuestion() {
		return question;
	}

	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponsePanel other = (ResponsePanel) obj;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}
	
	
}
