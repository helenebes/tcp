import java.util.ArrayList;
import java.util.List;

import contest.architecture.ContestManagementImpl;
import contest.architecture.UserManagementImpl;
import contest.architecture.VacancyManagementImpl;
import contest.database.Database;
import contest.ui.graphic.impl.ConinfGUInterface;
import contest.ui.graphic.impl.DeptBossGUInterface;
import contest.ui.graphic.impl.DeptSecretaryINAGUInterface;
import contest.ui.graphic.impl.SystemInterface;


public class System {

	public static void main(String[] args) {
		System system = new System();
	}
	
	protected final List<SystemInterface> systemInterfaces;
	
	public System() {
		Database database = new Database();
		
		ContestManagementImpl contestManagement = new ContestManagementImpl(database);
		UserManagementImpl userManagement = new UserManagementImpl(database);
		VacancyManagementImpl vacancyManagement = new VacancyManagementImpl(database);
		
		this.systemInterfaces = new ArrayList<>(3);
		
		systemInterfaces.add(new ConinfGUInterface(userManagement));
		systemInterfaces.add(new DeptBossGUInterface(userManagement));
		systemInterfaces.add(new DeptSecretaryINAGUInterface(userManagement));
		
		for(SystemInterface systemInterface : systemInterfaces) {
			systemInterface.createAndShowUI();
		}
		
	}
	
}
