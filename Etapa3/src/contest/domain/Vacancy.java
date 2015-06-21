package contest.domain;

import contest.ui.graphic.action.BusinessException;

public class Vacancy {

	private Profile profile;
	private User previousRecord;
	private Contest contest;
	
	public Vacancy(String profile, User previousRecord) {
		if (profile.equals("titular")) {
			this.profile = new Titular();
		} else if (profile.equals("assistente")) {
			this.profile = new Assistente();
		} else if (profile.equals("auxiliarly")) {
			this.profile = new Auxiliarly();			
		} else if (profile.equals("adjunct")) {
			this.profile = new Adjunct();
		} else {
			System.out.println("error");;
		}
		this.previousRecord = previousRecord;
	}
	
	public Profile getProfile() {
		return profile;
	}
	
	public User getVacancyPreviousRecord() {
		return previousRecord;
	}
	
	public Contest getContest() {
		return contest;
	}
}
