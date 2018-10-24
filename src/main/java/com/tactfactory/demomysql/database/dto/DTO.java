package com.tactfactory.demomysql.database.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tactfactory.demomysql.database.DBItem;

public interface DTO <T extends DBItem> {

	String javaToMySQL(T item);
	T mySQLToJava(ResultSet rs) throws SQLException;
}
