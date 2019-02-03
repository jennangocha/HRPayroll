package db.singleton;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class ConnectionString {
	String result = "";
	InputStream inputStream;
	private static ConnectionString instance=null;
	private ConnectionString() {}
	public static ConnectionString getConnectionString() {
		if(instance==null){
			instance=new ConnectionString();
		}
		return instance;
	}
	public HashMap<String,String> getPropValues() throws IOException {
		HashMap<String,String> h=new HashMap<String, String>();
		try {
			Properties prop = new Properties();
			String propFileName = "resources/config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			String database = prop.getProperty("database");
			 
			
			String conString ="jdbc:mysql://localhost:3306/"+ database + "?autoReconnect=true&useSSL=false";
			
			h.put("conString",conString);
			h.put("user",user);
			h.put("password",password);
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return h;
	}
}
