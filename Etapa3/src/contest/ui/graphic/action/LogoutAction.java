package contest.ui.graphic.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import contest.ui.graphic.impl.SystemGraphicInterface;

public class LogoutAction extends SystemAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8882123437908505812L;

	public LogoutAction(SystemGraphicInterface contestInterface) {
		super(contestInterface);
		// TODO Auto-generated constructor stub
		
		super.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		super.putValue(Action.NAME, "logout");
	}

	public void execute() {
		int answer = JOptionPane.showConfirmDialog(contestInterface.getFrame()
				.getContentPane(), "Are you sure to want to disconnect ?", contestInterface.getFrame()
				.getTitle(), JOptionPane.WARNING_MESSAGE);

		if (JOptionPane.YES_OPTION == answer) {
			contestInterface.logout();
		}
	}
}
