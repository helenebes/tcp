package contest.domain;

public class Vacancy {

	private Profile profile;
	private User previousRecord;
	private Contest contest;
	
	public void Vacancy(String profile) {

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
