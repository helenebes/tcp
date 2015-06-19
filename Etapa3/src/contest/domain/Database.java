package contest.domain;

import java.util.List;

public class Database {
	
	//attributes not created... I don't know if they will be needed..
	private List<Vacancy> vacancies;
	private List<Contest> contests;
	private List<Exam> exams;
	private ExaminationBoard examinationBoard;
	private List<Candidate> candidates;

	public void Database() {
		
	}
	
	public void save(Vacancy vacancy) {
		
	}
	
	public void save(Contest contest) {
		
	}
	
	public void save(Exam exam) {
		
	}
	
	public void save(ExaminationBoard examinationBoard) {
		
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
	
	
}
