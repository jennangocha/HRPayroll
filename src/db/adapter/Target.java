package db.adapter;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface Target {
	public Connection connect();
	public List<Map<String, String>> getdata(String Sql);
	public String[][] getdataString(String Sql);
}
