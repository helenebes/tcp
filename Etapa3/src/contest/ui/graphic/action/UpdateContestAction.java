package contest.ui.graphic.action;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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

public class UpdateContestAction extends SystemAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8978901940033993640L;

	private ContestManagementImpl contestManagementImpl;
	private List<Contest> contests;
	private JComboBox<String> contest;
	private JTextField data;
	private JDialog dialog;
	
	public UpdateContestAction(SystemGraphicInterface contestInterface, ContestManagementImpl contestManagementImpl) {
		super(contestInterface);
		this.contestManagementImpl = contestManagementImpl;

		super.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		super.putValue(Action.NAME, "update contest");
	}

	public void execute() {
		contests = contestManagementImpl.getAllContestsNotClosed();
		
		if(contests.isEmpty()) {
			GUIUtils.INSTANCE.showMessage(contestInterface.getFrame(),
					"no contest", JOptionPane.INFORMATION_MESSAGE);
		}
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel subpanel = new JPanel(new GridLayout(2, 2, 5, 5));

		String[] contestList = new String[contests.size()];
		int indiceContestList = 0;
		for(Contest contest : contests) {
			contestList[indiceContestList] = indiceContestList+ " - " + contest.getContestTitle();
			indiceContestList++;
		}
		contest = new JComboBox<>(contestList);
		subpanel.add(new JLabel("contest :"));
		subpanel.add(contest);
		
		data = new JTextField();
		subpanel.add(new JLabel("data :"));
		subpanel.add(data);

		panel.add(subpanel, BorderLayout.CENTER);

		subpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton ok = new JButton("ok");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateContest();
			}
		});
		subpanel.add(ok);
		panel.add(subpanel, BorderLayout.SOUTH);

		this.dialog = GUIUtils.INSTANCE.createDialog(contestInterface.getFrame(),
				"update contest", panel);
		this.dialog.setVisible(true);
	}
	
	private void updateContest() {
		try {
			int positionContest = Integer.parseInt(contest.getSelectedItem().toString().substring(0,1));
			Contest contestSelected = contests.get(positionContest);
			
			contestManagementImpl.updateContestData(data, contestSelected);;
			
			StringBuffer sb = new StringBuffer();
			sb.append("successful operation").append("\n");
			sb.append("contest title : ").append(contestSelected.getContestTitle()).append("\n");
			sb.append("data : ").append(data.toString()).append("\n");
			
			GUIUtils.INSTANCE.showMessage(contestInterface.getFrame(),
					sb.toString(), JOptionPane.INFORMATION_MESSAGE);
			dialog.dispose();
			
		} catch (Exception exc) {
			GUIUtils.INSTANCE.handleUnexceptedError(contestInterface.getFrame(),
					exc);
		}
	}

}
