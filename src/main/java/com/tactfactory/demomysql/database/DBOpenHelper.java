package com.tactfactory.demomysql.database;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DBOpenHelper {

	/** Constructeur privé */
    private DBOpenHelper()
    {
    	MysqlDataSource dataSource = new MysqlDataSource();
    	dataSource.setUser("antoine.cronier");
		dataSource.setPassword("root");
		dataSource.setServerName("127.0.0.1");
		dataSource.setDatabaseName("demomysql");
		try {
			dataSource.setServerTimezone("UTC");
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
     
    /** Instance unique non préinitialisée */
    private static DBOpenHelper INSTANCE = null;
     
    /** Point d'accès pour l'instance unique du singleton */
    public static synchronized DBOpenHelper getInstance()
    {           
        if (INSTANCE == null)
        {   INSTANCE = new DBOpenHelper(); 
        }
        return INSTANCE;
    }

	private Connection conn;

	public Connection getConn() {
		return conn;
	}
}
