package contest.ui.graphic.impl;

import contest.architecture.ContestManagementImpl;
import contest.architecture.UserManagementImpl;
import contest.architecture.VacancyManagementImpl;
import contest.ui.graphic.action.AssociateAction;
import contest.ui.graphic.action.CloseContestAction;
import contest.ui.graphic.action.CreateContestAction;
import contest.ui.graphic.action.CreateVacancyAction;
import contest.ui.graphic.action.ExitAction;
import contest.ui.graphic.action.LogoutAction;
import contest.ui.graphic.action.UpdateContestAction;
import contest.ui.graphic.action.UserLoginAction;

public class ConinfGUInterface extends SystemGraphicInterface {
	
	public ConinfGUInterface(UserManagementImpl userManagement, VacancyManagementImpl vacancyManagementImpl, ContestManagementImpl contestManagementImpl) {
		
		LogoutAction logoutAction = new LogoutAction(this);
		ExitAction exitAction = new ExitAction(this, logoutAction);
		this.setExitAction(exitAction);
		
		addMenuAction(new UserLoginAction(this, userManagement));
		addMenuAction(logoutAction);
		addMenuAction(exitAction);

		addPanelAction(new CreateVacancyAction(this, vacancyManagementImpl));
		addPanelAction(new CreateContestAction(this, contestManagementImpl));
		addPanelAction(new AssociateAction(this, contestManagementImpl));
		addPanelAction(new UpdateContestAction(this, contestManagementImpl));
		addPanelAction(new CloseContestAction(this, contestManagementImpl));
	}
	
	public String toString() {
		return "Coninf";
	}
}
