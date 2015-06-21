package contest.architecture;

import java.util.List;

import contest.database.Database;
import contest.domain.Profile;
import contest.domain.User;
import contest.domain.Vacancy;
import contest.ui.graphic.action.BusinessException;

public class VacancyManagementImpl implements VacancyManagement {
	
	private Database database;
	private List<Vacancy> vacancies;
	
	public VacancyManagementImpl(Database database) {
		this.database = database;
	}
	
	public Vacancy createVacancy(String profile, String username) throws BusinessException {
		User previousUser = database.getUser(username);
		if(previousUser == null) {
			throw new BusinessException("username not in the database");
		}
		Vacancy vacancy = new Vacancy(profile, previousUser);
		database.save(vacancy);
		return vacancy;
	}

}
