package contest.architecture;

import contest.database.Database;
import contest.domain.User;
import contest.ui.graphic.action.BusinessException;

public class UserManagementImpl {
	
	private final Database database;
	
	public UserManagementImpl(Database database) {
		this.database = database;
	}

	public User login(String username, String password)
		throws BusinessException {
			User user = database.getUser(username);

			if (user == null) {
				throw new BusinessException("inexistent employee");
			}
			if (!user.getPassword().equals(password)) {
				throw new BusinessException("invalid password");
			}

			return user;
	}
}
