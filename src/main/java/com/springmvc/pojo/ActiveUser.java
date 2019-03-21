package com.springmvc.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ActiveUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2213599757045449327L;
	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;//id
    private String account;//账号名
    private Integer roleId;//角色id
    private String roleName;//角色名称
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
