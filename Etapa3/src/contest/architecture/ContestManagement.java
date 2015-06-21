package contest.architecture;

import java.util.List;

import contest.domain.Contest;
import contest.domain.Vacancy;

public interface ContestManagement {

	public void createConcurso(String title, List<String> field);
	
	public void associate(Vacancy vacancy, Contest contest);
	
	public void updateConcursoData(Object data, Contest contest);
	
	public void closeConcurso(Contest contest);
}
