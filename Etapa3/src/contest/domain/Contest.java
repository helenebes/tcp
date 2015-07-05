package contest.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contest {

	private String contestTitle;
	private List<Vacancy> vacancies;
	private List<String> fields;
	private String workRegime;
	private Object program;
	private List<Status> statusLog;
	private Date startDate;
	private List<Candidate> candidates;
	private List<Exam> exams;
	private ExaminationBoard examinationBoard;
	private Schedule schedule;
	
	public Contest(String contestTitle, List<String> fields, String workRegime, String program) {
		this.contestTitle = contestTitle;
		this.fields = fields;
		this.workRegime = workRegime;
		this.startDate = new Date();
		this.program = program;
		this.statusLog = new ArrayList<Status>();
		this.statusLog.add(new WithoutProtocol("em preparacão"));
		this.candidates = new ArrayList<Candidate>();
		this.exams = new ArrayList<Exam>();
		this.vacancies = new ArrayList<Vacancy>();
	}
	
	public String getContestTitle() {
		return contestTitle;
	}
	
	public int getVacancyAmount() {
		return vacancies.size();
	}
	
	public List<Vacancy> getVacancies() {
		return vacancies;
	}
	
	public List<String> getFields() {
		return fields;
	}
	
	public String getWorkRegime() {
		return workRegime;
	}
	
	public Object getProgram() {
		return program;
	}
	
	public List<Status> getStatusLog() {
		return statusLog;
	}
	
	public ExaminationBoard getExaminationBoard() {
		return examinationBoard;
	}
	
	public void setExaminationBoard(ExaminationBoard examinationBoard) {
		this.examinationBoard = examinationBoard;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public List<Exam> getExams() {
		return exams;
	}
	
	public List<Candidate> getCandidates() {
		return candidates;
	}
	
	public void addCandidate(Candidate candidate) {
		this.candidates.add(candidate);
	}
	
	public Schedule getSchedule() {
		return schedule;
	}
	
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	public void addVacancy(Vacancy vacancy) {
		this.vacancies.add(vacancy);
	}

	public void addContestStatus(Status status) {
		this.statusLog.add(status);
	}
	
	public void addExam(Exam exam) {
		this.exams.add(exam);
	}
	
}
