package contest.architecture;

import java.util.List;

import contest.domain.Contest;
import contest.domain.Vacancy;
import contest.ui.graphic.action.BusinessException;

public interface ContestManagement {

	public Contest createContest(String title, List<String> field, String workRegime, String program);
	
	public void associate(Vacancy vacancy, Contest contest);
	
	public void updateContestSchedule(String schedule, Contest contest);
	
	public void updateContestCandidate(String firstName, String lastName, String email, int id, String urlCV, String file, Contest contest);
	
	public void updateContestBoard(String member1, String member2, String member3, String president, String surrogate1, String surrogate2, Contest contest) throws BusinessException;
	
	public void updateContestStatus(String status, Contest contest);
	
	public void updateContestStatus(String status, String justification, Contest contest) throws BusinessException;
	
	public void closeContest(Contest contest);
	
	public List<Contest> getAllContestsNotClosed();
	
	public List<Vacancy> getAllVacancies();
}
