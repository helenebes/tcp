package contest.architecture;

import java.util.List;

import contest.domain.Contest;
import contest.domain.Vacancy;

public interface ContestManagement {

	public Contest createContest(String title, List<String> field, String workRegime, String program);
	
	public void associate(Vacancy vacancy, Contest contest);
	
	public void updateContestData(Object data, Contest contest);
	
	public void closeContest(Contest contest);
	
	public List<Contest> getAllContestsNotClosed();
	
	public List<Vacancy> getAllVacancies();
}
