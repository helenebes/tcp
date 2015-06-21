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
import javax.swing.KeyStroke;

import contest.architecture.ContestManagementImpl;
import contest.domain.Contest;
import contest.domain.Vacancy;
import contest.ui.graphic.impl.GUIUtils;
import contest.ui.graphic.impl.SystemGraphicInterface;

public class AssociateAction extends SystemAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 924910050248758750L;
	
	private ContestManagementImpl contestManagementImpl;
	private JDialog dialog;
	private JComboBox<String> vacancy;
	private JComboBox<String> contest;
	private List<Vacancy> vacancies;
	private List<Contest> contests;
	
	public AssociateAction(SystemGraphicInterface contestInterface, ContestManagementImpl contestManagementImpl) {
		super(contestInterface);
		this.contestManagementImpl = contestManagementImpl;

		super.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		super.putValue(Action.NAME, "associate vacancy/contest");
	}
	
	public void execute() {
		vacancies = contestManagementImpl.getAllVacancies();
		contests = contestManagementImpl.getAllContests();
		
		if(vacancies.isEmpty()) {
			GUIUtils.INSTANCE.showMessage(contestInterface.getFrame(),
					"no vacancy", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(contests.isEmpty()) {
			GUIUtils.INSTANCE.showMessage(contestInterface.getFrame(),
					"no contest", JOptionPane.INFORMATION_MESSAGE);
		}
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JPanel subpanel = new JPanel(new GridLayout(5, 2, 5, 5));

		String[] contestList = new String[contests.size()];
		int indiceContestList = 0;
		for(Contest contest : contests) {
			contestList[indiceContestList] = indiceContestList+ " - " + contest.getContestTitle();
			indiceContestList++;
		}
		contest = new JComboBox<>(contestList);
		subpanel.add(new JLabel("contest :"));
		subpanel.add(contest);
		
		String[] vacancyList = new String[vacancies.size()];
		int indiceVacancyList = 0;
		for(Vacancy vacancy : vacancies) {
			vacancyList[indiceVacancyList] = indiceVacancyList+ " - " + vacancy.getProfile().getProfile();
			indiceVacancyList++;
		}
		vacancy = new JComboBox<>(vacancyList);
		subpanel.add(new JLabel("vacancy :"));
		subpanel.add(vacancy);

		panel.add(subpanel, BorderLayout.CENTER);

		subpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton ok = new JButton("ok");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				associate();
			}
		});
		subpanel.add(ok);
		panel.add(subpanel, BorderLayout.SOUTH);

		this.dialog = GUIUtils.INSTANCE.createDialog(contestInterface.getFrame(),
				"Association vacancy contest", panel);
		this.dialog.setVisible(true);
	}
	
	public void associate() {
		try {
			int positionContest = Integer.parseInt(contest.getSelectedItem().toString().substring(0,1));
			Contest contestSelected = contests.get(positionContest);
			
			int positionVacancy = Integer.parseInt(vacancy.getSelectedItem().toString().substring(0,1));
			Vacancy vacancySelected = vacancies.get(positionVacancy);
			
			contestManagementImpl.associate(vacancySelected, contestSelected);
			
			StringBuffer sb = new StringBuffer();
			sb.append("successful operation").append("\n");
			sb.append("contest title : ").append(vacancySelected.getContest().getContestTitle()).append("\n");
			sb.append("vacancy profile : ").append(vacancySelected.getProfile().getProfile()).append("\n");
			
			GUIUtils.INSTANCE.showMessage(contestInterface.getFrame(),
					sb.toString(), JOptionPane.INFORMATION_MESSAGE);
			dialog.dispose();
			
		} catch (Exception exc) {
			GUIUtils.INSTANCE.handleUnexceptedError(contestInterface.getFrame(),
					exc);
		}
	}

}
