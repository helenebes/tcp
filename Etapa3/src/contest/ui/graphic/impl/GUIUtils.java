package contest.ui.graphic.impl;


import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUIUtils {

	public static final GUIUtils INSTANCE = new GUIUtils();

	public JDialog createDialog(Frame owner, String title, JPanel panel) {
		JDialog dialog = new JDialog(owner, title, true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setResizable(false);
		dialog.setContentPane(panel);
		dialog.pack();
		Dimension locRef = Toolkit.getDefaultToolkit().getScreenSize();
		dialog.setLocation((locRef.width - dialog.getSize().width) / 2,
				(locRef.height - dialog.getSize().height) / 2);
		return dialog;
	}

	public void handleUnexceptedError(JFrame owner, Exception e) {
		showMessage(owner, "exception.unexpected", JOptionPane.ERROR_MESSAGE);
		//log.error(e);
		e.printStackTrace();
		System.exit(-1);
	}
	
	public void showMessage(JFrame owner, String key, int type) {
		showMessage(owner, key, new String[0], type);
	}

	public void showMessage(JFrame owner, String key, String arg, int type) {
		showMessage(owner, key, new String[] { arg }, type);
	}

	public void showMessage(JFrame owner, String key, String[] args, int type) {
		showMessage("application.title", owner, key, args, type);
	}

	public void showMessage(String title, JFrame owner, String key, int type) {
		showMessage(title, owner, key, new String[0], type);
	}

	public void showMessage(String title, JFrame owner, String key, String arg,
			int type) {
		showMessage(title, owner, key, new String[] { arg }, type);
	}

	public void showMessage(String title, JFrame owner, String key,
			String[] args, int type) {
		JOptionPane.showMessageDialog(owner.getContentPane(),
				key, title,
				type);
	}
	
	public boolean checkMandatory(JFrame owner, Object obj, String fieldName) {
		if (obj == null) {
			showMessage(owner, "exception.field.mandatory",
					new String[] { fieldName }, JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	public boolean checkMandatoryString(JFrame owner, String str,
			String fieldName) {
		if (str == null || "".equals(str)) {
			showMessage(owner, "exception.field.mandatory",
					new String[] { fieldName }, JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

}
