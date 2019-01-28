package app.service;


import app.dao.*;
import app.domain.*;

public class UserController {
private static UserController instance = new UserController();
	
	private IDataAccess<String, User> dataAccess = new DataAccessImpl<String, User>();
	
	private UserController() {}
	
	public static UserController getInstance() { return instance; }
	
	public User getUserByUsername(String id) {
		return dataAccess.get(id);
	}	
}
