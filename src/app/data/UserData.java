package app.data;

import app.domain.AccessLevel;
import app.domain.User;
import app.service.UserController;
/*Owner: Jmmy*/
class UserData {
	public static void load() {
		UserController controller = UserController.getInstance();
		User user1 = new User("Jimmy","1234",AccessLevel.ADMIN);
		User user2 = new User("admin","admin",AccessLevel.ADMIN);
		User user3 = new User("user1","12345678.",AccessLevel.EMPLOYEE);
		User user4 = new User("user2","12345678.",AccessLevel.EMPLOYEE);
		controller.addNewUser(user1);
		controller.addNewUser(user2);
		controller.addNewUser(user3);
		controller.addNewUser(user4);
		
	}
}
