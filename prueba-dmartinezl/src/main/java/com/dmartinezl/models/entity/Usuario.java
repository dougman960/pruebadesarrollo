package com.dmartinezl.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")

public class Usuario implements Serializable {

	@Id
	@Column(name = "user_id")
	private String id;

	@Column(unique = true)
	private String email;

	private String name;

	@Column(length = 60)
	private String password;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date created;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date modified;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date last_login;

	private Boolean enabled;
	
	private Integer intentos;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "user_id", "roles_id" }) })
	@JsonIgnoreProperties({ "hibernateLazyInitialzer" , "handler" })
	private List<Role> roles;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "phone_id")
	@JsonIgnoreProperties({ "hibernateLazyInitialzer" , "handler" })
	private List<Phone> phone;

	
	public void prePersist() {
		this.created = new Date();
		this.modified = new Date();
		this.last_login = new Date();
	}
	

	public String getId() {
		return id;
	}





	public void setId(String id) {
		this.id = id;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public Date getCreated() {
		return created;
	}





	public void setCreated(Date created) {
		this.created = created;
	}





	public Date getModified() {
		return modified;
	}





	public void setModified(Date modified) {
		this.modified = modified;
	}





	public Date getLast_login() {
		return last_login;
	}





	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}





	public Boolean getEnabled() {
		return enabled;
	}





	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}



	public Integer getIntentos() {
		return intentos;
	}


	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}


	public List<Role> getRoles() {
		return roles;
	}





	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}





	public List<Phone> getPhone() {
		return phone;
	}





	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}





	private static final long serialVersionUID = 1L;

}
