package com.weini.manage.business;

import javax.persistence.Entity;


@Entity
public class Auth  implements java.io.Serializable {
   
	private static final long serialVersionUID = 1039032343134369395L;
	private int id;
	private String name;

	/** default constructor */
    public Auth() {
    }
    
	public Auth(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}