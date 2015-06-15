/*
 * Created on 6 Jan 2014 21:13:34 
 */
package bank.ui.graphic.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import bank.business.AccountManagementService;
import bank.business.BusinessException;
import bank.business.domain.Transfer;
import bank.ui.TextManager;
import bank.ui.graphic.BankGraphicInterface;
import bank.ui.text.UIUtils;

/**
 * @author Ingrid Nunes
 * 
 */
public class TransferManagementAction extends BankAction {

	private static final long serialVersionUID = 5090183202921964451L;

	private AccountManagementService accountManagementService;

	private TextManager textManager;

	public TransferManagementAction(BankGraphicInterface bankInterface,
			TextManager textManager,
			AccountManagementService accountManagementService) {
		super(bankInterface, textManager);
		this.accountManagementService = accountManagementService;
		this.textManager = textManager;

		super.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		super.putValue(Action.NAME,
				textManager.getText("action.manage.transfer"));
	}
	
	@Override
	public void execute() throws BusinessException {
		//List<Transfer> transfers = accountManagementService.getAllTranfersToCheck();
		List<Transfer> transfers = new ArrayList<Transfer>();
		if (transfers.size() == 0) {
			JOptionPane.showMessageDialog(null, textManager.getText("message.noTransfer"), "Aviso", JOptionPane.WARNING_MESSAGE);		
		} else {
			int indiceTransfer = 0;
			String[] tranfers = new String[transfers.size()];
			for (Transfer transfer : transfers) {
				tranfers[indiceTransfer] = indiceTransfer+ " - " + UIUtils.INSTANCE.formatDateTime(transfer.getDate());
				indiceTransfer++;
			} 
			 
			String nom = (String)JOptionPane.showInputDialog(null, textManager.getText("message.select.transfer"), "", JOptionPane.QUESTION_MESSAGE, null, tranfers, tranfers[0]);
			int positionTransfer = Integer.parseInt(nom.substring(0, 1));
			Transfer transferSelected = transfers.get(positionTransfer);
			int option = JOptionPane.showConfirmDialog(null, textManager.getText("account.number") +" : " + 
					transferSelected.getAccount().getId().getNumber() + "\n \n"+  
					textManager.getText("destination.account.number") + " : " + transferSelected.getDestinationAccount().getId().getNumber() + "\n" +
					textManager.getText("amount") + " : " + transferSelected.getAmount() + "\n" +
					textManager.getText("message.confirm.transfer"), "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(option == JOptionPane.OK_OPTION){
				accountManagementService.authorizeTransfer(transferSelected);		
			}
			else {
				accountManagementService.cancelTransfer(transferSelected);
			}
		}
	}
}
