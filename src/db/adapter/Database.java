package db.adapter;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import db.singleton.ConnectionString;
import javafx.scene.control.Alert;


public class Database implements Target {
	private String ConnectionStr;
	private String username;
	private String password;
	public Database() {	
		ConnectionString c=ConnectionString.getConnectionString();		
		try {
			ConnectionStr=c.getPropValues().get("conString");
			username=c.getPropValues().get("user");
			password=c.getPropValues().get("password");
			//System.out.println(ConnectionStr+password);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			e.getMessage();
		}
	}
	public Connection connect(){
		Connection con=null;
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(ConnectionStr,username,password);  
			return con;
			
		}
		catch(Exception e)
		{ 
			System.out.println(e);
			return con;
		}  

	}
	public List<Map<String, String>> getdata(String Sql) {
		Connection con=connect();
		Statement stmt;
		List<Map<String, String>> obj=new ArrayList<Map<String, String>>();
		try {
			stmt = con.createStatement();
			con.createStatement();  
			ResultSet rs=stmt.executeQuery(Sql);  
			ResultSetMetaData meta = rs.getMetaData();
			String[] colName = new String[meta.getColumnCount()+1];
			for(int i=1;i<=meta.getColumnCount();i++) {
				colName[i]=meta.getColumnLabel(i);
			}
						
			while(rs.next()) {
				Map<String, String> map1 = new HashMap<String, String>();
				for(int i=1;i<=meta.getColumnCount();i++) {
					map1.put(colName[i], rs.getString(i));
					}
				obj.add(map1);
			}
			//System.out.println(obj); 
			con.close();  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	public String[][] getdataString(String Sql) {
		Connection con=connect();
		Statement stmt;
		String[][] obj=null;
		try {
			stmt = con.createStatement();
			con.createStatement();  
			ResultSet rs=stmt.executeQuery(Sql);  
			ResultSetMetaData meta = rs.getMetaData();
			String[] colName = new String[meta.getColumnCount()+1];
			for(int i=1;i<=meta.getColumnCount();i++) {
				colName[i]=meta.getColumnLabel(i);
			}
			
			obj=new String[10][meta.getColumnCount()];
			int k=0;
			while(rs.next()) {
				
				for(int i=0;i<meta.getColumnCount();i++) {
					obj[k][i]=rs.getString(i+1);
				}
				k++;
			}
			//System.out.println(obj); 
			con.close();  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
}
