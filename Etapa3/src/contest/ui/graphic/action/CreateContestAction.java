package contest.ui.graphic.action;

import java.util.List;

import contest.ui.graphic.impl.SystemGraphicInterface;

public class CreateContestAction extends SystemAction{

	protected CreateContestAction(SystemGraphicInterface contestInterface) {
		super(contestInterface);
		// TODO Auto-generated constructor stub
	}

	private String title;
	private List<String> fieldList;
	
	public void execute() {
		
	}
	
	public void createContest() {
		
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
