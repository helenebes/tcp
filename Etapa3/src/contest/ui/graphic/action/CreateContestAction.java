package contest.ui.graphic.action;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import contest.architecture.ContestManagementImpl;
import contest.domain.Contest;
import contest.ui.graphic.impl.GUIUtils;
import contest.ui.graphic.impl.SystemGraphicInterface;

public class CreateContestAction extends SystemAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6794520413721835783L;

	public CreateContestAction(SystemGraphicInterface contestInterface, ContestManagementImpl contestManagementImpl) {
		super(contestInterface);
		this.contestManagementImpl = contestManagementImpl;
		this.fieldList = new ArrayList<String>();

		super.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		super.putValue(Action.NAME, "create contest");
	}

	private ContestManagementImpl contestManagementImpl;
	private JTextField title;
	private JComboBox<String> workRegime;
	private JTextField field1;
	private JTextField field2;
	private JTextField field3;
	private JTextField program;
	private List<String> fieldList;
	private JDialog dialog;
		
	public void execute() {
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JPanel subpanel = new JPanel(new GridLayout(6, 2, 5, 5));
		
		this.title = new JTextField();
		title.setColumns(10);
		subpanel.add(new JLabel("title :"));
		subpanel.add(title);
		
		String[] workRegimeType = new String[]{"20H", "40H", "DE"};
		workRegime = new JComboBox<>(workRegimeType);
		subpanel.add(new JLabel("workRegime :"));
		subpanel.add(workRegime);

		this.field1 = new JTextField();
		field1.setColumns(10);
		subpanel.add(new JLabel("field1 :"));
		subpanel.add(field1);
		
		this.field2 = new JTextField();
		field2.setColumns(10);
		subpanel.add(new JLabel("field2 :"));
		subpanel.add(field2);
		
		this.field3 = new JTextField();
		field3.setColumns(10);
		subpanel.add(new JLabel("field3 :"));
		subpanel.add(field3);
		
		this.program = new JTextField();
		program.setColumns(10);
		subpanel.add(new JLabel("program :"));
		subpanel.add(program);

		panel.add(subpanel, BorderLayout.CENTER);

		subpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton ok = new JButton("ok");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				createContest();
			}
		});
		subpanel.add(ok);
		panel.add(subpanel, BorderLayout.SOUTH);

		this.dialog = GUIUtils.INSTANCE.createDialog(contestInterface.getFrame(),
				"creation contest", panel);
		this.dialog.setVisible(true);
	}
	
	private void createContest() {
		try {			
			if (!GUIUtils.INSTANCE.checkMandatoryString(
					contestInterface.getFrame(), title.getText(), "title"))
				return;
			if (!GUIUtils.INSTANCE.checkMandatoryString(
					contestInterface.getFrame(), field1.getText(), "field1"))
				return;
			if (!GUIUtils.INSTANCE.checkMandatoryString(
					contestInterface.getFrame(),program.getText(), "program"))
				return;
			
			fieldList.add(field1.getText());
			if(!field2.getText().isEmpty())
				fieldList.add(field2.getText());
			if(!field3.getText().isEmpty())
				fieldList.add(field3.getText());

			Contest contest = contestManagementImpl.createContest(title.getText(), fieldList, workRegime.getSelectedItem().toString(), program.getText());
			
			StringBuffer sb = new StringBuffer();
			sb.append("successful operation").append("\n");
			sb.append("title : ").append(contest.getContestTitle()).append("\n");
			sb.append("workRegime : ").append(contest.getWorkRegime()).append("\n");
			for(String field : contest.getFields()) {
				sb.append("field : ").append(field).append("\n");
			}
			
			
			GUIUtils.INSTANCE.showMessage(contestInterface.getFrame(),
					sb.toString(), JOptionPane.INFORMATION_MESSAGE);
			dialog.dispose();
			
		} catch (Exception exc) {
			GUIUtils.INSTANCE.handleUnexceptedError(contestInterface.getFrame(),
					exc);
		}
	}
}
