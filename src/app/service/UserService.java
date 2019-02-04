package app.service;


import app.domain.*;
import app.repository.*;
/*Owner: Jmmy*/
public class UserService {
private static UserService instance = new UserService();
	
	private IDataAccess<String, User> dataAccess = new DataAccessImpl<String, User>();
	
	private UserService() {}
	
	public static UserService getInstance() { return instance; }
	
	public User addNewUser(User User) {
		return dataAccess.add(User.getUsername(), User);
	}
	
	public User getUserByUsername(String id) {
		return dataAccess.get(id);
	}	
	
	
}
