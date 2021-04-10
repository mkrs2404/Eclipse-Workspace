package com.login.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginDao {
	
	String url = "jdbc:mysql://localhost:3306/mydb";
	String query = "Select * from login where uname=? and pass=?";
	String username = "root";
	String password = "root";
	
	public boolean check(String uname, String pass) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, uname);
			st.setString(2, pass);
			ResultSet rs= st.executeQuery();
			if(rs.next())
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
