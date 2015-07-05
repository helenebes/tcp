package contest.architecture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import contest.database.Database;
import contest.domain.Contest;
import contest.domain.Status;
import contest.domain.Vacancy;
import contest.domain.WithoutProtocol;

public class ContestManagementImpl implements ContestManagement {

	private Database database;
	
	public ContestManagementImpl(Database database) {
		this.database = database;
	}
	
	public Contest createContest(String title, List<String> fields, String workRegime, String program) {
		Contest contest = new Contest(title, fields, workRegime, program);
		database.save(contest);
		return contest;
	}
	
	public void associate(Vacancy vacancy, Contest contest) {
		vacancy.addContest(contest);
		contest.addVacancy(vacancy);
	}
	
	public void updateContestData(Object data, Contest contest) {
		//contest.setContestData(date);
	}
	
	public void closeContest(Contest contest){
		contest.addContestStatus(new WithoutProtocol("closed"));
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
	
	public List<Contest> getAllContestsNotClosed() {
		List<Contest> contests = new ArrayList<Contest>();
		Boolean isclosed = false;
		for (Contest contest : database.getContests()) {
			Iterator<Status> statusIterator = contest.getStatusLog().iterator();
			while(statusIterator.hasNext()) {
				if (statusIterator.next().getStatus().contains("closed"))
					isclosed = true;
			}
			if (!isclosed)
				contests.add(contest);
			isclosed = false;			
		}
		return contests;
	}
	
	public List<Vacancy> getAllVacancies() {
		return database.getVacancies();
	}
}
