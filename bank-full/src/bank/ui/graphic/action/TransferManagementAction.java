/*
 * Created on 6 Jan 2014 21:13:34 
 */
package bank.ui.graphic.action;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import bank.business.AccountManagementService;
import bank.business.BusinessException;
import bank.business.domain.CurrentAccount;
import bank.business.domain.Transfer;
import bank.ui.TextManager;
import bank.ui.graphic.BankGraphicInterface;
import bank.ui.graphic.GUIUtils;

/**
 * @author Ingrid Nunes
 * 
 */
public class TransferManagementAction extends BankAction {

	private static final long serialVersionUID = 5090183202921964451L;

	private AccountManagementService accountManagementService;

	private JFormattedTextField balance;
	protected JFormattedTextField birthday;
	protected JFormattedTextField cpf;
	private JDialog dialog;
	protected JTextField lastName;
	protected JTextField name;

	public TransferManagementAction(BankGraphicInterface bankInterface,
			TextManager textManager,
			AccountManagementService accountManagementService) {
		super(bankInterface, textManager);
		this.accountManagementService = accountManagementService;

		super.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		super.putValue(Action.NAME,
				textManager.getText("action.manage.transfer"));
	}

	private void printAllTranferPendente(List<Transfer> transfers) {
		//TODO
	}
	
	private void printTranferInfo(Transfer transfer) {
		//TODO
	}

	private void authorizeTransfer(Transfer transfer) {
		//TODO
	}
	
	private void forbidTransfer(Transfer transfer) {
		//TODO
	}
	
	@Override
	public void execute() {
			//TODO
	}
}
