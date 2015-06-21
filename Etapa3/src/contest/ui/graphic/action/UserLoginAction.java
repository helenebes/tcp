package contest.ui.graphic.action;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import contest.architecture.UserManagementImpl;
import contest.domain.User;
import contest.ui.graphic.impl.GUIUtils;
import contest.ui.graphic.impl.SystemGraphicInterface;

public class UserLoginAction extends SystemAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JDialog dialog;
	private JPasswordField password;
	private JTextField username;
	private UserManagementImpl userManagement;

	public UserLoginAction(SystemGraphicInterface contestInterface, UserManagementImpl userManagement) {
		super(contestInterface);
		this.userManagement = userManagement;
		
		super.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		super.putValue(Action.NAME, "login");
		setEnabled(true);
	}

	
	public void execute() {
		this.username = new JTextField();
		username.setColumns(10);
		this.password = new JPasswordField();
		password.setColumns(10);

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JPanel subpanel = new JPanel(new GridLayout(2, 2, 5, 5));
		subpanel.add(new JLabel("username :"));
		subpanel.add(username);
		subpanel.add(new JLabel("password :"));
		subpanel.add(password);
		panel.add(subpanel, BorderLayout.CENTER);

		subpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton ok = new JButton("ok");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				executeLogin();
			}
		});
		subpanel.add(ok);
		panel.add(subpanel, BorderLayout.SOUTH);

		this.dialog = GUIUtils.INSTANCE.createDialog(contestInterface.getFrame(),
			"login", panel);
		this.dialog.setVisible(true);
	}

	private void executeLogin() {
		try {
			User user = userManagement.login(
					username.getText(), new String(password.getPassword()));
			contestInterface.login(user);
			dialog.dispose();
			dialog = null;
		} catch (BusinessException be) {
			System.out.println("error");
			//GUIUtils.INSTANCE.showMessage(contestInterface.getFrame(),
				//	be.getMessage(), be.getArgs(), JOptionPane.WARNING_MESSAGE);
			//log.warn(be);
		}/* catch (Exception exc) {
			GUIUtils.INSTANCE.handleUnexceptedError(bankInterface.getFrame(),
					exc);
		}*/
	}

	
	public void warnCurrentVacancies() {
		
	}
	
	public void warnRejection() {
		
	}

}
