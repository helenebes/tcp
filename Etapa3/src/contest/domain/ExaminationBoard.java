package contest.domain;

import java.util.List;

public class ExaminationBoard {
	// in the class diagram using list<Person> and List<User>... I just used list<Person> but to confirm..
	
	private List<Person> members;
	private List<Person> surrogates;
	private Person president;
	
	public ExaminationBoard(List<Person> members, List<Person> surrogates, Person president){
		this.members = members;
		this.surrogates = surrogates;
		this.president = president;
	}
	
	public List<Person> getExaminationBoard() {
		return members;
	}
	
	public List<Person> getSurrogate(){
		return surrogates;
	}
	
	public Person getPresidentBanking() {
		return president;
	}
}
