package contest.ui.graphic.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.KeyStroke;

import contest.ui.graphic.impl.SystemGraphicInterface;

public class ExitAction extends SystemAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1445209112241558065L;
	private LogoutAction logoutAction;
	
	public ExitAction(SystemGraphicInterface contestInterface, LogoutAction logoutAction) {
		super(contestInterface);
		super.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		super.putValue(Action.NAME, "exit");
		setEnabled(true);
		this.logoutAction = logoutAction;
	}
	public void execute() {
		if (contestInterface.isLoggedIn()) {
			logoutAction
					.actionPerformed(new ActionEvent(this,
							ActionEvent.ACTION_PERFORMED, logoutAction
									.getCommandKey()));
			if (contestInterface.isLoggedIn()) {
				return;
			}
		}
		System.exit(0);
	}
	
	@Override
	public void setEnabled(boolean status) {
		super.setEnabled(true);
	}
}
