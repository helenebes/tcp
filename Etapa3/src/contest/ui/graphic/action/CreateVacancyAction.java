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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import contest.architecture.VacancyManagementImpl;
import contest.domain.Vacancy;
import contest.ui.graphic.impl.GUIUtils;
import contest.ui.graphic.impl.SystemGraphicInterface;

public class CreateVacancyAction extends SystemAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5419039073780803852L;

	public CreateVacancyAction(SystemGraphicInterface contestInterface, VacancyManagementImpl vacancyManagementImpl) {
		super(contestInterface);
		this.vacancyManagementImpl = vacancyManagementImpl;
		// TODO Auto-generated constructor stub
		
		super.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		super.putValue(Action.NAME, "create vacancy");
	}

	private JComboBox<String> profile;
	private JTextField username;
	private JDialog dialog;
	private VacancyManagementImpl vacancyManagementImpl;
	
	public void execute() {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JPanel subpanel = new JPanel(new GridLayout(5, 2, 5, 5));

		this.username = new JTextField();
		username.setColumns(10);
		subpanel.add(new JLabel("userName"));
		subpanel.add(username);

		String[] profileType = new String[]{"titular", "adjunct", "assistente", "auxiliarky"};
		profile = new JComboBox<>(profileType);
		subpanel.add(profile);
		//profile.addItemListener(this);

		panel.add(subpanel, BorderLayout.CENTER);

		subpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton ok = new JButton("ok");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				createVacancy();
			}
		});
		subpanel.add(ok);
		panel.add(subpanel, BorderLayout.SOUTH);

		this.dialog = GUIUtils.INSTANCE.createDialog(contestInterface.getFrame(),
				"action.transfer", panel);
		this.dialog.setVisible(true);
	}
	
	public void createVacancy() {
		try {			
			if (!GUIUtils.INSTANCE.checkMandatoryString(
					contestInterface.getFrame(), username.getText(), "firstName"))
				return;


			Vacancy vacancy = vacancyManagementImpl.createVacancy(profile.getSelectedItem().toString(), username.getText());
			
			StringBuffer sb = new StringBuffer();
			sb.append("successful operation").append("\n");
			sb.append("username : ").append(vacancy.getVacancyPreviousRecord().getUserName()).append("\n");
			sb.append("profile : ").append(vacancy.getProfile().getProfile()).append("\n");
			
			GUIUtils.INSTANCE.showMessage(contestInterface.getFrame(),
					sb.toString(), JOptionPane.INFORMATION_MESSAGE);
			dialog.dispose();
			
		} catch (BusinessException be) {
			GUIUtils.INSTANCE.showMessage(contestInterface.getFrame(),
					be.getMessage(), be.getArgs(), JOptionPane.WARNING_MESSAGE);
			//log.warn(be);
		} catch (Exception exc) {
			GUIUtils.INSTANCE.handleUnexceptedError(contestInterface.getFrame(),
					exc);
		}
	}	
}
