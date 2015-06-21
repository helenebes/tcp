package contest.domain;

public class WithProtocol extends Status {
	
	public WithProtocol(String status, String justification) {
		super(status);
		this.justification = justification;
	}
	
	private enum type { APROVADO, REPROVADO };
	private String justification;
}
