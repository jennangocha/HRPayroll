package app.data;

import app.domain.AccessLevel;
import app.domain.User;
import app.service.UserController;

public class UserData {
	public static void load() {
		UserController controller = UserController.getInstance();
		User user1 = new User("Jimmy","1234",AccessLevel.ADMIN);
		User user2 = new User("Bealfan","12345678.",AccessLevel.ADMIN);
		User user3 = new User("Edwin","12345678.",AccessLevel.EMPLOYEE);
		User user4 = new User("Jesse","12345678.",AccessLevel.EMPLOYEE);
		User user5 = new User("Vorlea","12345678.",AccessLevel.EMPLOYEE);
		controller.addNewUser(user1);
		controller.addNewUser(user2);
		controller.addNewUser(user3);
		controller.addNewUser(user4);
		controller.addNewUser(user5);
	}
}
