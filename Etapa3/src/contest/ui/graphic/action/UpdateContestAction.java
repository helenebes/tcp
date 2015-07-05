package contest.ui.graphic.action;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
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
	private JComboBox<String> update;
	private JComboBox<String> status;
	private JDialog dialog;
	private JTextField schedule;
	private JTextField 	justification;
	private JTextField lastName;
	private JTextField firstName;
	private JTextField email;
	private JFormattedTextField id;
	private JTextField urlCV;
	private JTextField file;
	private JTextField member1;
	private JTextField member2;
	private JTextField member3;
	private JTextField 	surrogate1;
	private JTextField 	surrogate2;
	private JTextField 	president;
	
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
		else {
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
			subpanel.add(new JLabel("Select the contest :"));
			subpanel.add(contest);
			
			String[] updateTypeConinf = new String[]{"Status"};
			String[] updateTypeDepartment = new String[]{"Schedule", "Status", "Candidate", "Examination Board"};
			if (contestInterface.toString().contains("Coninf")) {
				update = new JComboBox<>(updateTypeConinf);
				subpanel.add(new JLabel("Type of update :"));
				subpanel.add(update);
			} else {
				update = new JComboBox<>(updateTypeDepartment);
				subpanel.add(new JLabel("Type of update :"));
				subpanel.add(update);
			}			
	
			panel.add(subpanel, BorderLayout.CENTER);
	
			subpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			JButton ok = new JButton("ok");
			ok.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					updateType();
				}
			});
			subpanel.add(ok);
			panel.add(subpanel, BorderLayout.SOUTH);
	
			this.dialog = GUIUtils.INSTANCE.createDialog(contestInterface.getFrame(),
					"update contest", panel);
			this.dialog.setVisible(true);
		}
	}
	
	private void updateType() {
		if(update.getSelectedItem().toString().equals("Schedule"))
			updateSchedule();
		else if (update.getSelectedItem().toString().equals("Status"))
			updateStatus();
		else if (update.getSelectedItem().toString().equals("Candidate"))
			updateCandidate();
		else
			updateBoard();
	}
	
	private void updateSchedule() {
		dialog.dispose();
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel subpanel = new JPanel(new GridLayout(2, 2, 5, 5));

		schedule = new JTextField();
		subpanel.add(new JLabel("Schedule :"));
		subpanel.add(schedule);

		panel.add(subpanel, BorderLayout.CENTER);

		subpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton ok = new JButton("ok");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateContestSchedule();
			}
		});
		subpanel.add(ok);
		panel.add(subpanel, BorderLayout.SOUTH);

		this.dialog = GUIUtils.INSTANCE.createDialog(contestInterface.getFrame(),
				"update schedule", panel);
		this.dialog.setVisible(true);
		
	}
	
	private void updateStatus() {
		dialog.dispose();
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel subpanel = new JPanel(new GridLayout(2, 2, 5, 5));
		
		String[] statusType = new String[]{"Approved by colegiado", "Rejected by colegiado", "approved by coninf", "rejected by coninf", "open enrollment", "under evaluation by progesp", "approved by progesp"};
		status = new JComboBox<>(statusType);
		subpanel.add(new JLabel("Type of status :"));
		subpanel.add(status);

		justification = new JTextField();
		subpanel.add(new JLabel("Justification :"));
		subpanel.add(justification);
		
		panel.add(subpanel, BorderLayout.CENTER);

		subpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton ok = new JButton("ok");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateContestStatus();
			}
		});
		subpanel.add(ok);
		panel.add(subpanel, BorderLayout.SOUTH);

		this.dialog = GUIUtils.INSTANCE.createDialog(contestInterface.getFrame(),
				"update status", panel);
		this.dialog.setVisible(true);
		
	}
	
	private void updateCandidate() {
		dialog.dispose();
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel subpanel = new JPanel(new GridLayout(8, 2, 5, 5));

		firstName = new JTextField();
		subpanel.add(new JLabel("FirstName :"));
		subpanel.add(firstName);
		
		lastName = new JTextField();
		subpanel.add(new JLabel("LastName :"));
		subpanel.add(lastName);

		email = new JTextField();
		subpanel.add(new JLabel("Email :"));
		subpanel.add(email);
		
		id = new JFormattedTextField(NumberFormat.getIntegerInstance());
		subpanel.add(new JLabel("Id :"));
		subpanel.add(id);
		
		urlCV = new JTextField();
		subpanel.add(new JLabel("CV url :"));
		subpanel.add(urlCV);
		
		file = new JTextField();
		subpanel.add(new JLabel("File :"));
		subpanel.add(file);
		
		panel.add(subpanel, BorderLayout.CENTER);

		subpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton ok = new JButton("ok");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateContestCandidate();
			}
		});
		subpanel.add(ok);
		panel.add(subpanel, BorderLayout.SOUTH);

		this.dialog = GUIUtils.INSTANCE.createDialog(contestInterface.getFrame(),
				"update candidate", panel);
		this.dialog.setVisible(true);
		
	}
	
	private void updateBoard() {
		dialog.dispose();
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel subpanel = new JPanel(new GridLayout(7, 2, 5, 5));

		member1 = new JTextField();
		subpanel.add(new JLabel("Member1 :"));
		subpanel.add(member1);
		
		member2 = new JTextField();
		subpanel.add(new JLabel("Member2 :"));
		subpanel.add(member2);

		member3 = new JTextField();
		subpanel.add(new JLabel("Member3 :"));
		subpanel.add(member3);
		
		president = new JTextField();
		subpanel.add(new JLabel("President :"));
		subpanel.add(president);
		
		surrogate1 = new JTextField();
		subpanel.add(new JLabel("Surrogate1 :"));
		subpanel.add(surrogate1);
		
		surrogate2 = new JTextField();
		subpanel.add(new JLabel("Surrogate2 :"));
		subpanel.add(surrogate2);
		
		panel.add(subpanel, BorderLayout.CENTER);

		subpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton ok = new JButton("ok");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateContestBoard();
			}
		});
		subpanel.add(ok);
		panel.add(subpanel, BorderLayout.SOUTH);

		this.dialog = GUIUtils.INSTANCE.createDialog(contestInterface.getFrame(),
				"update board", panel);
		this.dialog.setVisible(true);
		
	}
	
	private void updateContestSchedule() {
		try {
			if (!GUIUtils.INSTANCE.checkMandatoryString(
					contestInterface.getFrame(), schedule.getText(), "schedule"))
				return;
			
			int positionContest = Integer.parseInt(contest.getSelectedItem().toString().substring(0,1));
			Contest contestSelected = contests.get(positionContest);
			
			contestManagementImpl.updateContestSchedule(schedule.getText(), contestSelected);
			
			StringBuffer sb = new StringBuffer();
			sb.append("successful operation").append("\n");
			sb.append("contest title : ").append(contestSelected.getContestTitle()).append("\n");
			sb.append("schedule : ").append(schedule.getText()).append("\n");
			
			GUIUtils.INSTANCE.showMessage(contestInterface.getFrame(),
					sb.toString(), JOptionPane.INFORMATION_MESSAGE);
			dialog.dispose();
			
		} catch (Exception exc) {
			GUIUtils.INSTANCE.handleUnexceptedError(contestInterface.getFrame(),
					exc);
		}
	}
	
	private void updateContestStatus() {
		try {
			int positionContest = Integer.parseInt(contest.getSelectedItem().toString().substring(0,1));
			Contest contestSelected = contests.get(positionContest);
			
			if(justification.getText().contains("")) 
				contestManagementImpl.updateContestStatus(status.getSelectedItem().toString() , contestSelected);
			else
				contestManagementImpl.updateContestStatus(status.getSelectedItem().toString(), justification.getText(), contestSelected);
			
			StringBuffer sb = new StringBuffer();
			sb.append("successful operation").append("\n");
			sb.append("contest title : ").append(contestSelected.getContestTitle()).append("\n");
			sb.append("new status : ").append(status.getSelectedItem()).append("\n");
			
			GUIUtils.INSTANCE.showMessage(contestInterface.getFrame(),
					sb.toString(), JOptionPane.INFORMATION_MESSAGE);
			dialog.dispose();
			
		} catch (Exception exc) {
			GUIUtils.INSTANCE.handleUnexceptedError(contestInterface.getFrame(),
					exc);
		}
	}

	private void updateContestCandidate() {
		try {
			if (!GUIUtils.INSTANCE.checkMandatoryString(
					contestInterface.getFrame(), firstName.getText(), "firstName"))
				return;
			if (!GUIUtils.INSTANCE.checkMandatoryString(
					contestInterface.getFrame(), lastName.getText(), "lastName"))
				return;
			if (!GUIUtils.INSTANCE.checkMandatoryString(
					contestInterface.getFrame(), email.getText(), "email"))
				return;
			if (!GUIUtils.INSTANCE.checkMandatory(contestInterface.getFrame(),
					id.getValue(), "id"))
				return;
			if (!GUIUtils.INSTANCE.checkMandatoryString(
					contestInterface.getFrame(), urlCV.getText(), "url"))
				return;
			if (!GUIUtils.INSTANCE.checkMandatoryString(
					contestInterface.getFrame(), file.getText(), "file"))
				return;
		
			
			int positionContest = Integer.parseInt(contest.getSelectedItem().toString().substring(0,1));
			Contest contestSelected = contests.get(positionContest);
			
			contestManagementImpl.updateContestCandidate(firstName.getText(), lastName.getText(), email.getText(), ((Number) id.getValue()).intValue(), urlCV.getText(), file.getText(), contestSelected);
			
			StringBuffer sb = new StringBuffer();
			sb.append("successful operation").append("\n");
			sb.append("contest title : ").append(contestSelected.getContestTitle()).append("\n");
			sb.append("candidate : ").append(firstName.getText()).append(" ").append(lastName.getText()).append("\n");
			
			GUIUtils.INSTANCE.showMessage(contestInterface.getFrame(),
					sb.toString(), JOptionPane.INFORMATION_MESSAGE);
			dialog.dispose();
			
		} catch (Exception exc) {
			GUIUtils.INSTANCE.handleUnexceptedError(contestInterface.getFrame(),
					exc);
		}
	}
	
	private void updateContestBoard() {
		try {
			if (!GUIUtils.INSTANCE.checkMandatoryString(
					contestInterface.getFrame(), member1.getText(), "member1"))
				return;
			if (!GUIUtils.INSTANCE.checkMandatoryString(
					contestInterface.getFrame(), member2.getText(), "member2"))
				return;
			if (!GUIUtils.INSTANCE.checkMandatoryString(
					contestInterface.getFrame(), member3.getText(), "member3"))
				return;
			if (!GUIUtils.INSTANCE.checkMandatoryString(
					contestInterface.getFrame(), president.getText(), "president"))
				return;
			if (!GUIUtils.INSTANCE.checkMandatoryString(
					contestInterface.getFrame(), surrogate1.getText(), "surrogate1"))
				return;
			if (!GUIUtils.INSTANCE.checkMandatoryString(
					contestInterface.getFrame(), surrogate2.getText(), "surrogate2"))
				return;
		
			
			int positionContest = Integer.parseInt(contest.getSelectedItem().toString().substring(0,1));
			Contest contestSelected = contests.get(positionContest);
			
			contestManagementImpl.updateContestBoard(member1.getText(), member2.getText(), member3.getText(), president.getText(), surrogate1.getText(), surrogate2.getText(), contestSelected);
			
			StringBuffer sb = new StringBuffer();
			sb.append("successful operation").append("\n");
			sb.append("contest title : ").append(contestSelected.getContestTitle()).append("\n");
			sb.append("president : ").append(president.getText()).append("\n");
			
			GUIUtils.INSTANCE.showMessage(contestInterface.getFrame(),
					sb.toString(), JOptionPane.INFORMATION_MESSAGE);
			dialog.dispose();
			
		} catch (Exception exc) {
			GUIUtils.INSTANCE.handleUnexceptedError(contestInterface.getFrame(),
					exc);
		}
	}
	
}
