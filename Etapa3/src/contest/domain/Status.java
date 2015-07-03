package contest.domain;

public abstract class Status {
	
	//Add not in the class diagramm
	private String justification;
	private String status;
	
	public Status(String status, String justification) {
		this.status = status;
		this.justification = justification;
	}
	
	public Status(String status) {
		this.status = status;
		this.justification = "";
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
