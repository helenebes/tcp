package contest.domain;

import java.util.Date;
import java.util.List;

public class Contest {

	private int contestId;
	private String contestTitle;
	private List<Vacancy> vacancies;
	private List<String> fields;
	private String workRegime;
	private Object program;
	private List<Status> statusLog;
	private Date startDate;
	private List<Candidate> result;
	private List<Exam> exams;
	
	public Contest(String contestTitle, List<String> fields) {
		this.contestTitle = contestTitle;
		this.fields = fields;
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
		return null;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public List<Candidate> getResult() {
		return result;
	}
	
	public List<Protocol> getProtocol() {
		return null;
	}
	
	public Profile getProfile() {
		return null;
	}
	
	public List<Exam> getExams() {
		return exams;
	}
	
	public List<Candidate> getCandidates() {
		return null;
	}
	
	public Schedule getSchedule() {
		return null;
	}
	
	public void addVacancy(Vacancy vacancy) {
		
	}

	public void setContestStatus(Status status) {
		this.statusLog.add(status);
	}
	
	public void setContestData(Date date) {
		this.startDate = date;
	}
	
}
