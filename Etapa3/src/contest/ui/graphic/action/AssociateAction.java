package contest.ui.graphic.action;

import contest.domain.Contest;
import contest.domain.Vacancy;
import contest.ui.graphic.impl.SystemGraphicInterface;

public class AssociateAction extends SystemAction{

	private Vacancy vacancy;
	private Contest contest;
	
	public AssociateAction(SystemGraphicInterface contestInterface) {
		super(contestInterface);
	}
	
	public void execute() {
		
	}
	
	public void associate() {
		
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
