package com.tactfactory.demomysql.entities;

import com.tactfactory.demomysql.database.DBItem;

public class Role extends DBItem {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role(String name) {
		super();
		this.name = name;
	}
	
	public Role() {
	}
}
