package contest.architecture;

import java.util.List;

import contest.database.Database;
import contest.domain.Contest;
import contest.domain.Vacancy;
import contest.domain.WithoutProtocol;

public class ContestManagementImpl implements ContestManagement {

	private Database database;
	
	public ContestManagementImpl(Database database) {
		this.database = database;
	}
	
	public Contest createContest(String title, List<String> fields, String workRegime) {
		Contest contest = new Contest(title, fields, workRegime);
		database.save(contest);
		return contest;
	}
	
	public void associate(Vacancy vacancy, Contest contest) {
		vacancy.addContest(contest);
		contest.addVacancy(vacancy);
	}
	
	public void updateContestData(Object data, Contest contest) {
		
	}
	
	public void closeContest(Contest contest){
		contest.setContestStatus(new WithoutProtocol("closed"));
	}
	
	private boolean isFieldAvailable(List<String> fields) {
		return false;
	}
	
	private boolean isAssociationValid(Vacancy vacancy, Contest contest) {
		return false;
	}
	
	private boolean hasAssociatedProtocol() {
		return false;
	}
	
	private boolean isApprovedByColegiado() {
		return false;
	}
	
	public List<Contest> getAllContests() {
		return database.getContests();
	}
	
	public List<Vacancy> getAllVacancies() {
		return database.getVacancies();
	}
}
