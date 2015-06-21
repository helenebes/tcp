package contest.ui.graphic.action;

import contest.domain.Contest;
import contest.ui.graphic.impl.SystemGraphicInterface;

public class CloseContestAction extends SystemAction{

	protected CloseContestAction(SystemGraphicInterface contestInterface) {
		super(contestInterface);
		// TODO Auto-generated constructor stub
	}

	private Contest contest;
	
	public void execute() {
		
	}
	
	public void closeContest() {
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEnabled(boolean status) {
		// TODO Auto-generated method stub
		
	}
}
