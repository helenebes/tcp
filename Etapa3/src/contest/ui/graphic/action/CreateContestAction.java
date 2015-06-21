package contest.ui.graphic.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.Action;
import javax.swing.KeyStroke;

import contest.architecture.ContestManagementImpl;
import contest.architecture.VacancyManagementImpl;
import contest.ui.graphic.impl.SystemGraphicInterface;

public class CreateContestAction extends SystemAction {

	public CreateContestAction(SystemGraphicInterface contestInterface, ContestManagementImpl contestManagementImpl) {
		super(contestInterface);
		this.contestManagementImpl = contestManagementImpl;

		super.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		super.putValue(Action.NAME, "create contest");
	}

	private ContestManagementImpl contestManagementImpl;
	private String title;
	private List<String> fieldList;
	
	public void execute() {
		
	}
	
	public void createContest() {
		
	}
}
