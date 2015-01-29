package com.weini.manage.entity;

import javax.persistence.Entity;

@Entity
public class TAdmin  implements java.io.Serializable {
   
	private static final long serialVersionUID = 8219783208388795965L;
	private int order;
    private int adminID;
    private String adminName;
    private String adminPassword;
    private int roleID;
    private String roleName;

	/** default constructor */
    public TAdmin() {
    }

	public TAdmin(int order, int adminID, String adminName,
			String adminPassword, int roleID, String roleName) {
		super();
		this.order = order;
		this.adminID = adminID;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.roleID = roleID;
		this.roleName = roleName;
	}
	
	public TAdmin(int adminID,int order, String adminName,String pwd) {
		super();
		this.adminID=adminID;
		this.order = order;
		this.adminName = adminName;
		this.adminPassword=pwd;
	}

	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}