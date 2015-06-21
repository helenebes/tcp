package contest.ui.graphic.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.KeyStroke;

import contest.architecture.ContestManagementImpl;
import contest.domain.Contest;
import contest.ui.graphic.impl.SystemGraphicInterface;

public class CloseContestAction extends SystemAction{

	public CloseContestAction(SystemGraphicInterface contestInterface, ContestManagementImpl contestManagementImpl) {
		super(contestInterface);
		this.contestManagementImpl = contestManagementImpl;
		
		super.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		super.putValue(Action.NAME, "close contest");
	}

	private ContestManagementImpl contestManagementImpl;
	private Contest contest;
	
	public void execute() {
		
	}
	
	public void closeContest() {
		
	}

}
