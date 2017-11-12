import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class QuestionPanel extends ResponsePanel {

	private static final long serialVersionUID = 1L;
	private JButton btn = new JButton("SUBMIT");
	public static int counter = 0;
	private ButtonGroup bgroup;
	
	QuestionPanel(String question) {
		super(question);
		this.add(getSelectionOptions(), BorderLayout.SOUTH);
	}
	
	public JPanel getSelectionOptions() {
		JPanel selection = new JPanel();
		selection.setLayout(new FlowLayout());
		bgroup = new ButtonGroup();
		JRadioButton no = new JRadioButton("NO");
		no.setActionCommand("NO");
		JRadioButton yes = new JRadioButton("YES");
		yes.setActionCommand("YES");
		bgroup.add(yes);
		bgroup.add(no);
		selection.add(yes);
		selection.add(no);
		btn.addActionListener(action);
		selection.add(btn);
		return selection;
	}

	ActionListener action = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			try {
				setSelection(bgroup.getSelection().getActionCommand());
				setFlag(true);
			} catch (NullPointerException f) {
				JOptionPane.showMessageDialog(null, "NO OPTION SELECTED");
			}
		}
	};
}
