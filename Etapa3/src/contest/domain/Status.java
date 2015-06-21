package contest.domain;

public abstract class Status {
	
	//Add not in the class diagramm
	private String justification;
	private String status;
	
	public Status(String status) {
		this.status = status;
	}
	
	public boolean isRejected() {
		if(status.contains("reject"))
			return true;
		return false;
	}
	
	public String getJustification() {
		return justification;
	}
	
	public String getStatus() {
		return status;
	}
}
