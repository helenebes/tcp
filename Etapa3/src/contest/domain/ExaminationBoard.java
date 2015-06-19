package contest.domain;

import java.util.List;

public class ExaminationBoard {
	// in the class diagram using list<Person> and List<User>... I just used list<Person> but to confirm..
	
	private List<Person> members;
	
	public List<Person> getExaminationBoard() {
		return members;
	}
	
	public List<Person> getSurrogate(){
		return null;
	}
	
	public Person getPresidentBanking() {
		return null;
	}
}
