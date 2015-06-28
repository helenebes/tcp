package contest.ui.graphic.impl;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import contest.architecture.UserManagementImpl;
import contest.ui.graphic.action.SystemAction;
import contest.ui.graphic.action.ExitAction;

public abstract class SystemGraphicInterface extends SystemInterface {
	
	public class WindowHandler extends WindowAdapter {

		public void windowClosing(WindowEvent e) {
			exitAction.actionPerformed(new ActionEvent(this,
					ActionEvent.ACTION_PERFORMED, exitAction.getCommandKey()));
		}

	}

	private ExitAction exitAction;
	private final JFrame frame;
	private final JMenu mainMenu;
	private final JMenuBar menu;
	private final JPanel panel;
	private UserManagementImpl userManagement;
	
	public SystemGraphicInterface(UserManagementImpl userManagement) {
		this.userManagement = userManagement;
		this.frame = new JFrame();
		this.menu = new JMenuBar();
		this.mainMenu = new JMenu("System");
		this.menu.add(mainMenu);
		this.panel = new JPanel(getLayoutManager());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}
	
	protected void addAction(SystemAction action) {
		this.addAction(action.getCommandKey(), action);
	}

	protected void addMenuAction(SystemAction action) {
		mainMenu.add(new JMenuItem(action));
		addAction(action);
	}

	protected void addPanelAction(SystemAction action) {
		panel.add(new JButton(action));
		addAction(action);
	}	
	
	public void createAndShowUI() {
		if(this.toString().contains("DeptBoss"))
			frame.setTitle("System Head of Departement"); 
		else if(this.toString().contains("Coninf"))
			frame.setTitle("System CONINF");
		else if(this.toString().contains("DeptSec"))
			frame.setTitle("System INA Secretary");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowHandler());
		frame.setVisible(false);

		frame.setJMenuBar(menu);
		frame.setContentPane(panel);

		frame.pack();
		center();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame.setVisible(true);
			}
		});
	}
	
	public boolean isLogged() {
		return false;
	}
	
	public void center() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((screen.width - frame.getSize().width) / 2,
				(screen.height - frame.getSize().height) / 2);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public ExitAction getExitAction() {
		return exitAction;
	}
	
	protected GridLayout getLayoutManager() {
		return new GridLayout(3, 2, 5, 5);
	}
	
	protected void setExitAction(ExitAction exitAction) {
		this.exitAction = exitAction;
	}
}
