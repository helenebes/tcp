package contest.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import contest.domain.Candidate;
import contest.domain.Contest;
import contest.domain.Exam;
import contest.domain.ExaminationBoard;
import contest.domain.User;
import contest.domain.Vacancy;
import contest.ui.graphic.action.BusinessException;

public class Database {
	
	//attributes not created... I don't know if they will be needed..
	private final List<Vacancy> vacancies;
	private final List<Contest> contests;
	private final List<Exam> exams;
	private ExaminationBoard examinationBoard;
	private final List<Candidate> candidates;
	private final Map<String, User> users;

	public Database() throws BusinessException {
		this.users = new HashMap<>();
		this.vacancies = new ArrayList<>();
		this.contests = new ArrayList<>();
		this.exams = new ArrayList<>();
		this.candidates = new ArrayList<>();
		initData();
	}
	
	public void save(Vacancy vacancy) {
		this.vacancies.add(vacancy);
	}
	
	public void save(Contest contest) {
		this.contests.add(contest);
	}
	
	public void save(Exam exam) {
		this.exams.add(exam);
	}
	
	public void save(ExaminationBoard examinationBoard) {
		this.examinationBoard = examinationBoard;
	}

	public List<Vacancy> getVacancies() {
		return vacancies;
	}

	public List<Contest> getContests() {
		return contests;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public ExaminationBoard getExaminationBoard() {
		return examinationBoard;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}
	
	public User getUser(String username) {
		return users.get(username);
	}
	
	private void initData() throws BusinessException {
		User user1 = new User("Silva", "guilherme", 1, "user", "a", "secretary", null);
		this.users.put(user1.getUserName(), user1);
		
		Vacancy vacancy = new Vacancy("titular", user1);
		save(vacancy);
		
		Contest contest1 = new Contest("title", new ArrayList<String>(), "20H");
		save(contest1);
	}
}
