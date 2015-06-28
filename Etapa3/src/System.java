import java.util.ArrayList;
import java.util.List;

import contest.architecture.ContestManagementImpl;
import contest.architecture.UserManagementImpl;
import contest.architecture.VacancyManagementImpl;
import contest.database.Database;
import contest.ui.graphic.action.BusinessException;
import contest.ui.graphic.impl.DeptSecretaryINAGUInterface;
import contest.ui.graphic.impl.SystemInterface;


public class System {

	public static void main(String[] args) throws BusinessException {
		Database database = new Database();
		
		ContestManagementImpl contestManagement = new ContestManagementImpl(database);
		UserManagementImpl userManagement = new UserManagementImpl(database);
		VacancyManagementImpl vacancyManagement = new VacancyManagementImpl(database);
		
		List<SystemInterface> systemInterfaces = new ArrayList<>(3);
		
		//systemInterfaces.add(new ConinfGUInterface(userManagement, vacancyManagement, contestManagement));
		//systemInterfaces.add(new DeptBossGUInterface(userManagement, vacancyManagement, contestManagement));
		systemInterfaces.add(new DeptSecretaryINAGUInterface(userManagement, vacancyManagement, contestManagement));
		
		for(SystemInterface systemInterface : systemInterfaces) {
			systemInterface.createAndShowUI();
		}
	}
	
}
