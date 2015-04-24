package bank.ui.text.command;

import java.util.Date;
import java.util.List;

import bank.business.AccountManagementService;
import bank.business.domain.CurrentAccount;
import bank.business.domain.Transfer;
import bank.ui.text.BankTextInterface;
import bank.ui.text.UIUtils;

/**
 * @author Ingrid Nunes
 * 
 */
public class TransferManagementCommand extends Command {

	private final AccountManagementService accountManagementService;

	public TransferManagementCommand(BankTextInterface bankInterface,
			AccountManagementService accountManagementService) {
		super(bankInterface);
		this.accountManagementService = accountManagementService;
	}

	private void printAllTranferPendente(List<Transfer> transfers) {
		//TODO
	}
	
	private void printTranferInfo(Transfer transfer) {
		//TODO
	}

	
	@Override
	public void execute() throws Exception {
		//TODO
	}

}
