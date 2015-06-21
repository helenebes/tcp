package contest.architecture;

import java.util.List;

import contest.database.Database;
import contest.domain.Profile;
import contest.domain.Vacancy;

public class VacancyManagementImpl implements VacancyManagement {
	
	private Database database;
	private List<Vacancy> vacancies;
	
	public VacancyManagementImpl(Database database) {
		this.database = database;
	}
	
	public void createVacancy(Profile profile){
		
	}

}
