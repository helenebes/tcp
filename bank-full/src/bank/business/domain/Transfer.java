package bank.business.domain;

/**
 * @author Ingrid Nunes
 * 
 */
public class Transfer extends Transaction {

	private CurrentAccount destinationAccount;
	
	private String state;

	public void setFinishedState() {
		this.state = "FINALIZADA";
	}
	
	public void setCanceledState() {
		this.state = "CANCELADA";
	}

	public Transfer(OperationLocation location, CurrentAccount account,
			CurrentAccount destinationAccount, double amount, String state) {
		super(location, account, amount);
		this.destinationAccount = destinationAccount;
		this.state = state;
	}

	/**
	 * @return the destinationAccount
	 */
	public CurrentAccount getDestinationAccount() {
		return destinationAccount;
	}
	
	public String getState() {
		return state;
	}

}
