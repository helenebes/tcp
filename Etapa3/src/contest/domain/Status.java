package contest.domain;

public class Status {
	
	//Add not in the class diagramm
	private String justification;
	private String status;
	
	private boolean isRejected() {
		return false;
	}
	
	public String getJustification() {
		return justification;
	}
	
	public String getStatus() {
		return status;
	}
}
