package com.tactfactory.demomysql.database.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tactfactory.demomysql.database.contracts.UserContract;
import com.tactfactory.demomysql.entities.User;

public class UserDTO implements DTO<User> {

	@Override
	public String javaToMySQL(User item) {
		StringBuilder result = new StringBuilder();
		result.append("'" + item.getFirstname() + "'");
		result.append(",");
		result.append("'" + item.getLastname() + "'");
		return result.toString();
	}

	@Override
	public User mySQLToJava(ResultSet rs) throws SQLException {
		User user = new User();
		
		user.setId(rs.getInt(rs.findColumn(UserContract.FIELDS[0])));
		user.setFirstname(rs.getString(rs.findColumn(UserContract.FIELDS[1])));
		user.setLastname(rs.getString(rs.findColumn(UserContract.FIELDS[2])));
		
		return user;
	}

}
