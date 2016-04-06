package helper.db;

import java.util.*;
import java.sql.*;

import helper.info.*;

public class MySQLdb {
	private String url = "jdbc:mysql://localhost:3306/ibanmayo";
    private String user = "root"; 
    private String passwd = "root";
	private String driver = "com.mysql.jdbc.Driver";
	
    private Connection conn;
	
	public MySQLdb() {
		try {
        	Class.forName(this.driver).newInstance();
        	this.conn = DriverManager.getConnection(this.url,this.user,this.passwd);
    	} catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}

	public void setUserInfo(String email, String password, String username, String name, String surname1, String surname2, String kalea, String city, String zenbakia, String nan, String taldea, String lizentzia) {
		String query = "INSERT INTO ibanmayo.users VALUES ('" + email + "', '" + password + "', '" + username + "', '" + name + "', '" + surname1 + "', '" + surname2 + "', '" + kalea + "', '" + city + "', '" + zenbakia + "', '" + nan + "', '" + taldea + "', '" + lizentzia + "');";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = this.conn.createStatement();
	    	st.executeUpdate(query);  	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
 
	public void setUserInfoEguneratu(String email, String password, String username, String name, String surname1, String surname2, String kalea, String city, String zenbakia, String nan, String taldea, String lizentzia) {
		String query = "UPDATE ibanmayo.users SET  name= '"+ name + "', surname1 = '"+ surname1 +"', surname2 = '"+ surname2 +"', kalea = '"+ kalea +"', city = '"+ city +"', zenbakia = '"+ zenbakia +"', nan = '"+ nan +"', taldea = '"+ taldea +"', lizentzia = '"+ lizentzia + "' WHERE username='" + username  + "';";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = this.conn.createStatement();
	    	st.executeUpdate(query);  	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	
	public void lizentziaEguneratu(String username, String lizentzia) {
		String query = "UPDATE ibanmayo.users SET  lizentzia= '"+ lizentzia + "' WHERE username='" + username  + "';";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = this.conn.createStatement();
	    	st.executeUpdate(query);  	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	
	public String getUsername(String email, String password) {
		String query = "SELECT username FROM ibanmayo.users WHERE email='" + email + "' AND password='" + password + "';";
		System.out.println("     DB query: " + query);
		String username = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		username = res.getString("username");
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return username;
	}
	public String getEmail(String username) {
		String query = "SELECT email FROM ibanmayo.users WHERE username='" + username  + "';";
		System.out.println("     DB query: " + query);
		String emaila = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		emaila = res.getString("email");
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return emaila;
	}
	
	public String getPassword(String username) {
		String query = "SELECT password FROM ibanmayo.users WHERE username='" + username  + "';";
		System.out.println("     DB query: " + query);
		String pass = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		pass = res.getString("password");
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return pass;
	}
	
	public String getLizentzia(String username) {
		String query = "SELECT lizentzia FROM ibanmayo.users WHERE username='" + username  + "';";
		System.out.println("     DB query: " + query);
		String lizen = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		lizen = res.getString("lizentzia");
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return lizen;
	}
	
	
	public void pasahitzaEguneratu(String email, String passwordZ, String passwordB) {
		String query = "UPDATE ibanmayo.users SET password='" +passwordB+ "' WHERE email='" + email  + "' AND password = '" +passwordZ+ "'";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = this.conn.createStatement();
	    	st.executeUpdate(query);
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	
	
	
	public ArrayList<Object> getInformazioa(String email) {
		String query = "SELECT * FROM ibanmayo.users WHERE email='" + email + "';";
		System.out.println("     DB query: " + query);
		ArrayList<Object> userInfo = new ArrayList<Object>();
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		userInfo.add(res.getObject("name"));
	    		userInfo.add(res.getObject("surname1"));
	    		userInfo.add(res.getObject("surname2"));
	    		userInfo.add(res.getObject("kalea"));
	    		userInfo.add(res.getObject("city"));
	    		userInfo.add(res.getObject("zenbakia"));
	    		userInfo.add(res.getObject("nan"));
	    		userInfo.add(res.getObject("taldea"));
	    		userInfo.add(res.getObject("lizentzia"));
	    		
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return userInfo;
	}
	
	public void setMessageInfo(String message, String username) {
		String query = "INSERT INTO ibanmayo.messages VALUES ('0', '" + message + "', '" + username + "');";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = this.conn.createStatement();
	    	st.executeUpdate(query);  	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	
	public ArrayList<MessageInfo> getAllMessages() {
		String query = "SELECT * FROM ibanmayo.messages;";
		System.out.println("     DB query: " + query);
		ArrayList<MessageInfo> messageInfoList = new ArrayList<MessageInfo>(); 
    	try {
	    	Statement st = this.conn.createStatement();
        	ResultSet res = st.executeQuery(query); 
        	while(res.next()) {
        		messageInfoList.add(new MessageInfo(res.getString("message"), res.getString("username")));
        	} 	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return messageInfoList;
	}
	
}