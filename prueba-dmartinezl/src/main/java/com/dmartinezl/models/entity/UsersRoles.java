package com.dmartinezl.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "users_roles")
@IdClass(UsersRoles.class)
public class UsersRoles implements Serializable {

	@Id
	private String user_id;

	@Id
	@Column(name = "roles_id")
	private Long role_id;
	

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	private static final long serialVersionUID = 1L;

}
