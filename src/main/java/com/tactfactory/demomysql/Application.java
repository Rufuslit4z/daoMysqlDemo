package com.tactfactory.demomysql;

import java.util.ArrayList;

import com.tactfactory.demomysql.database.contracts.UserContract;
import com.tactfactory.demomysql.database.dao.DAOManager;
import com.tactfactory.demomysql.database.dto.UserDTO;
import com.tactfactory.demomysql.entities.User;

public class Application {

	public static void main(String[] args) {
		DAOManager<User> userDAOManager = new DAOManager<>();
		ArrayList<User> user = userDAOManager.selectAll(new UserContract(), new UserDTO());
	}

}
