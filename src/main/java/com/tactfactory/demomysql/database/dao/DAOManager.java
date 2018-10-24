package com.tactfactory.demomysql.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tactfactory.demomysql.database.DBItem;
import com.tactfactory.demomysql.database.DBOpenHelper;
import com.tactfactory.demomysql.database.contracts.Contract;
import com.tactfactory.demomysql.database.contracts.RoleContract;
import com.tactfactory.demomysql.database.contracts.UserContract;
import com.tactfactory.demomysql.database.dto.DTO;

public class DAOManager <T extends DBItem> {

	public ArrayList<T> selectAll(Contract contract, DTO<T> dto) {
		ArrayList<T> result = new ArrayList<T>();
		
		StringBuilder request = new StringBuilder();
		request.append("SELECT ");
		request.append("(");
		request.append(contract.getSelectFields());
		request.append(")");
		request.append(" FROM ");
		request.append(contract.getTable());
		
		Statement stmt = null;
		
		parser(dto, result, request, stmt);
		
		return result;
	}
	
	public ArrayList<T> select(Contract contract, DTO<T> dto, String desc, String value) {
		ArrayList<T> result = new ArrayList<T>();
		
		StringBuilder request = new StringBuilder();
		request.append("SELECT ");
		request.append("(");
		request.append(contract.getSelectFields());
		request.append(")");
		request.append(" FROM ");
		request.append(contract.getTable());
		request.append(" WHERE ");
		request.append(desc);
		request.append(" = ");
		request.append(value);
		
		Statement stmt = null;
		
		parser(dto, result, request, stmt);
		
		return result;
	}

	private void parser(DTO<T> dto, ArrayList<T> result, StringBuilder request, Statement stmt) {
		ResultSet rs;
		try {
			stmt = DBOpenHelper.getInstance().getConn().createStatement();
			rs = stmt.executeQuery(request.toString());
			while (rs.next()) {
				result.add(dto.mySQLToJava(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public DAOManager() {
		
		ArrayList<String> tablesNames = new ArrayList<String>();
		tablesNames.add(UserContract.TABLE);
		tablesNames.add(RoleContract.TABLE);
		
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<String> realTablesNames = new ArrayList<String>();
		
		try {
			stmt = DBOpenHelper.getInstance().getConn().createStatement();
			rs = stmt.executeQuery("SHOW TABLES");
			while (rs.next()) {
				realTablesNames.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		tablesNames.containsAll(realTablesNames);
	}
}
