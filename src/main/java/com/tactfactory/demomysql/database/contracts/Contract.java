package com.tactfactory.demomysql.database.contracts;

public interface Contract {

	String getTable();
	String[] getFields();
	String getCreateTable();
	String getSelectFields();
}
