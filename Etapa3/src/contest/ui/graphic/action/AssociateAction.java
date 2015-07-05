package contest.ui.graphic.action;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
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
		subpanel.add(new JLabel("Select the contest :"));
		subpanel.add(contest);

		panel.add(subpanel, BorderLayout.CENTER);

		subpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton ok = new JButton("next");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				associateVacancy();
			}
		});
		subpanel.add(ok);
		panel.add(subpanel, BorderLayout.SOUTH);

		this.dialog = GUIUtils.INSTANCE.createDialog(contestInterface.getFrame(),
				"Association vacancy contest", panel);
		this.dialog.setVisible(true);
	}
	

	private void associateVacancy() {
		
		dialog.dispose();
		
		int positionContest = Integer.parseInt(contest.getSelectedItem().toString().substring(0,1));
		Contest contestSelected = contests.get(positionContest);
		if(!contestSelected.getVacancies().isEmpty()) {
			vacancies = new ArrayList<Vacancy>();
			Iterator<Vacancy> iteratorVacancy = contestSelected.getVacancies().iterator();
			Vacancy firstVacancy = iteratorVacancy.next();
			List<Vacancy> allVacancies = contestManagementImpl.getAllVacancies();
			for (Vacancy vacancy : allVacancies) {
				if(vacancy.getProfile().getProfile().equals(firstVacancy.getProfile().getProfile()))
					vacancies.add(vacancy);
					vacancies.remove(firstVacancy);
					while(iteratorVacancy.hasNext()) {
						vacancies.remove(iteratorVacancy.next());
					}
			}
		} else {
			vacancies = contestManagementImpl.getAllVacancies();
		}
		if(vacancies.isEmpty()) {
			GUIUtils.INSTANCE.showMessage(contestInterface.getFrame(),
					"no vacancy", JOptionPane.INFORMATION_MESSAGE);
		}
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JPanel subpanel = new JPanel(new GridLayout(2, 2, 5, 5));
		
		String[] vacancyList = new String[vacancies.size()];
		int indiceVacancyList = 0;
		for(Vacancy vacancy : vacancies) {
			vacancyList[indiceVacancyList] = indiceVacancyList+ " - profile : " + vacancy.getProfile().getProfile() + " / last user : " + vacancy.getVacancyPreviousRecord().getLastName();
			indiceVacancyList++;
		}
		vacancy = new JComboBox<>(vacancyList);
		subpanel.add(new JLabel("Select the vacancy :"));
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
	
	private void associate() {
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
