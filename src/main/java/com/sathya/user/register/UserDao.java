package com.sathya.user.register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


	public int SaveUser(String username,String password,String email,String mobile) {
		int result=0;
		Connection connection=DatabaseUtils.createConnection();
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("insert into user_register values(?,?,?,?)");
		
		preparedStatement.setString(1,username);
		preparedStatement.setString(2,password);
		preparedStatement.setString(3,email);
		preparedStatement.setString(4,mobile);
		
		result=preparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
		
		
		
	}
	public  UserInfo findByEmail (String email) {
		UserInfo UserInfo=null;
		Connection connection=DatabaseUtils.createConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("select * from user_register where email=?");
			preparedStatement.setString(1, email);
			ResultSet resultSet=preparedStatement.executeQuery();
			 if(resultSet.next()) {
			
			UserInfo=new UserInfo();
			UserInfo.setUsername(resultSet.getString(1));
			UserInfo.setPassword(resultSet.getString(2));
		    UserInfo.setEmail(resultSet.getString(3));
			UserInfo.setMobile(resultSet.getString(4));
			 }
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return UserInfo;
		
	}
	
	
	public int deleteByMobile(String mobile) {
		int result=0;
		Connection connection=DatabaseUtils.createConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("delete from user_register where mobile=?");
			preparedStatement.setString(1, mobile);
			 result=preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
public List<UserInfo>getAllUsers(){
	List<UserInfo>listOfusers=new ArrayList<UserInfo>();
	Connection connection=DatabaseUtils.createConnection();
	try {
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from user_register");
		while (resultSet.next()) {
		UserInfo userInfo=new UserInfo();
		
		userInfo.setUsername(resultSet.getString(1));
		userInfo.setPassword(resultSet.getString(2));
		userInfo.setEmail(resultSet.getString(3));
		userInfo.setMobile(resultSet.getString(4));
		listOfusers.add(userInfo);
		}
	    }
	catch(SQLException e) {
		e.printStackTrace();
	}
	return listOfusers;
	
}
	}
