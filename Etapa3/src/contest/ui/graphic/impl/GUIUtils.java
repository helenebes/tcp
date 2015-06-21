package contest.ui.graphic.impl;


import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JDialog;
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


}
