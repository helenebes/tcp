package contest.ui.graphic.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.KeyStroke;

import contest.architecture.ContestManagementImpl;
import contest.domain.Contest;
import contest.domain.Vacancy;
import contest.ui.graphic.impl.SystemGraphicInterface;

public class AssociateAction extends SystemAction{

	private ContestManagementImpl contestManagementImpl;
	private Vacancy vacancy;
	private Contest contest;
	
	public AssociateAction(SystemGraphicInterface contestInterface, ContestManagementImpl contestManagementImpl) {
		super(contestInterface);
		this.contestManagementImpl = contestManagementImpl;

		super.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		super.putValue(Action.NAME, "associate vacancy/contest");
	}
	
	public void execute() {
		
	}
	
	public void associate() {
		
	}

}
