package contest.ui.graphic.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import contest.ui.graphic.impl.SystemGraphicInterface;
import contest.ui.graphic.impl.UIAction;

public abstract class SystemAction extends AbstractAction implements UIAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7858614572326492580L;
	
	protected final SystemGraphicInterface contestInterface;

	protected SystemAction(SystemGraphicInterface contestInterface) {
		super();
		this.contestInterface = contestInterface;
		
		super.putValue(Action.ACCELERATOR_KEY, null);
		super.putValue(Action.ACTION_COMMAND_KEY, this.getClass()
				.getSimpleName());
		super.putValue(Action.LONG_DESCRIPTION, null);
		super.putValue(Action.MNEMONIC_KEY, null);
		super.putValue(Action.NAME, null);
		super.putValue(Action.SHORT_DESCRIPTION, null);
		super.putValue(Action.SMALL_ICON, null);
		super.setEnabled(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		//try {
			execute();
		//} catch (BusinessException be) {
			/*GUIUtils.INSTANCE.showMessage(bankInterface.getFrame(),
					be.getMessage(), be.getArgs(), JOptionPane.WARNING_MESSAGE);
			log.warn(be);
		} catch (Exception exc) {
			GUIUtils.INSTANCE.handleUnexceptedError(bankInterface.getFrame(),
					exc);*/
		//}
	}
	
	public String getCommandKey() {
		return (String) getValue(Action.ACTION_COMMAND_KEY);
	}
}
