package bank.ui.text.command;

import java.util.List;

import bank.business.AccountManagementService;
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
	
	@Override
	public void execute() throws Exception {
		//show all transfers
		List<Transfer> transfers = accountManagementService.getAllTranfersToCheck();
		
		StringBuffer sb = new StringBuffer();
		int indiceTransfer = 0;
		for (Transfer transfer : transfers) {
			sb.append(indiceTransfer).append(" - ");
			sb.append(UIUtils.INSTANCE.formatDateTime(transfer.getDate()))
			.append("\n");
			indiceTransfer++;
		}
		System.out.println(sb);
		Integer transferNum = UIUtils.INSTANCE.readInteger("message.select.transfer");
		Transfer transfer = transfers.get(transferNum);
		
		//for the testing part
		/*ATM atm = new ATM(3);
		Branch b = new Branch(5, "Centro");
		Client client1 = new Client("Ingrid", "Nunes", 1234568910, "123",
				new Date());
		Client client2 = new Client("Ingridee", "Nunes", 123456780, "123",
				new Date());
		CurrentAccount ca2 = new CurrentAccount(b, 2l, client2, 200);
		CurrentAccount ca1 = new CurrentAccount(b, 1l, client1, 300);
		Transfer transfer = new Transfer(atm, ca1, ca2, 20000, "PENDENTE");*/
		
		//Print informations on the transfer selected
		System.out.println(getTextManager().getText("account.number") + ": "
				+ transfer.getAccount().getId().getNumber());
		System.out.println(getTextManager().getText("destination.account.number") + ": "
				+ transfer.getDestinationAccount().getId().getNumber());
		System.out.println(getTextManager().getText("amount") + ": "
				+ transfer.getAmount());


		System.out.println(getTextManager().getText(
				"message.confirm.transfer"));
		String authorisation = UIUtils.INSTANCE.readString("authorisation");
		
		if (authorisation.compareTo("Y") == 0) {
			accountManagementService.authorizeTransfer(transfer);		
		}
		else {
			accountManagementService.cancelTransfer(transfer);
		}
		System.out.println(getTextManager().getText(
				"message.operation.succesfull"));	
	}

}
