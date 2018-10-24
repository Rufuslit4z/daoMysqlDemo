package com.tactfactory.demomysql.database.contracts;

public class UserContract implements Contract {

	public static final String TABLE = "user";
	public static final String[] FIELDS = {"id","firstname","lastname"};
	public static final String CREATE_TABLE =
			"CREATE TABLE " + TABLE + "(" +
					FIELDS[0] + " INT " + " NOT NULL " + " PRIMARY KEY AUTO_INCREMENT " + ","+
					FIELDS[1] + " VARCHAR(255) " + "," +
					FIELDS[2] + " VARCHAR(255) " +
			")";
	public static final String SELECT_FIELDS = 
			FIELDS[0] + "," + FIELDS[1] + "," + FIELDS[2];
	
	@Override
	public String getTable() {
		return TABLE;
	}
	
	@Override
	public String[] getFields() {
		return FIELDS;
	}
	
	@Override
	public String getCreateTable() {
		return CREATE_TABLE;
	}

	@Override
	public String getSelectFields() {
		return SELECT_FIELDS;
	}
}
