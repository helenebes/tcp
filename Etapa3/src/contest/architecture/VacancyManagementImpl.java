package contest.architecture;

import contest.database.Database;
import contest.domain.User;
import contest.domain.Vacancy;
import contest.ui.graphic.action.BusinessException;

public class VacancyManagementImpl implements VacancyManagement {
	
	private Database database;
	
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
