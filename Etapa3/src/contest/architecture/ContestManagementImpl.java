package contest.architecture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import contest.database.Database;
import contest.domain.Candidate;
import contest.domain.Contest;
import contest.domain.CurriculumVitae;
import contest.domain.ExaminationBoard;
import contest.domain.Person;
import contest.domain.Schedule;
import contest.domain.Status;
import contest.domain.Vacancy;
import contest.domain.WithProtocol;
import contest.domain.WithoutProtocol;
import contest.ui.graphic.action.BusinessException;

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
	
	public void updateContestSchedule(String schedule, Contest contest) {
		contest.setSchedule(new Schedule(schedule));
	}
	
	public void updateContestCandidate(String firstName, String lastName, String email, int id, String urlCV, String file, Contest contest) {
		contest.addCandidate(new Candidate(lastName, firstName, email, new CurriculumVitae(urlCV, file), id));
	}
	
	public void updateContestBoard(String member1, String member2, String member3, String president, String surrogate1, String surrogate2, Contest contest) throws BusinessException {
		List<Person> members = new ArrayList<Person>();
		List<Person> surrogates = new ArrayList<Person>();
		if (database.getUser(member1) == null) {
			throw new BusinessException("inexistent member1");
		}
		if (database.getUser(member2) == null) {
			throw new BusinessException("inexistent member2");
		}
		if (database.getUser(member3) == null) {
			throw new BusinessException("inexistent member3");
		}
		if (database.getUser(surrogate1) == null) {
			throw new BusinessException("inexistent surrogate1");
		}
		if (database.getUser(surrogate2) == null) {
			throw new BusinessException("inexistent surrogate2");
		}
		if (database.getUser(president) == null) {
			throw new BusinessException("inexistent president");
		}
		
		members.add(database.getUser(member1));
		members.add(database.getUser(member2));
		members.add(database.getUser(member3));
		surrogates.add(database.getUser(surrogate1));
		surrogates.add(database.getUser(surrogate2));
		Person presidentPerson = database.getUser(president);
		ExaminationBoard examinationBoard = new ExaminationBoard(members, surrogates, presidentPerson);
		contest.setExaminationBoard(examinationBoard);
	}
	
	public void updateContestStatus(String status, Contest contest) {
		Status newStatus = new WithoutProtocol(status);
		contest.addContestStatus(newStatus);
	}
	
	public void updateContestStatus(String status, String justification, Contest contest) throws BusinessException {
		String type;
		if(status.contains("approved"))
			type = "aprovado";
		else
			type = "reprovado";
		Status newStatus = new WithProtocol(status, justification, type);
		contest.addContestStatus(newStatus);
	}
	
	public void closeContest(Contest contest){
		contest.addContestStatus(new WithoutProtocol("closed"));
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
