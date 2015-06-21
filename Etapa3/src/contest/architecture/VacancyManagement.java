package contest.architecture;

import contest.domain.Vacancy;
import contest.ui.graphic.action.BusinessException;

public interface VacancyManagement {

	public Vacancy createVacancy(String profile, String username) throws BusinessException;
}
