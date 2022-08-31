package com.dmartinezl.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
@IdClass(Phone.class)
public class Phone implements Serializable {

	@Id
	@Column(name = "phone_id")
	private String id;

	@Id
	private String number;

	private String citiCode;

	private String contryCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitiCode() {
		return citiCode;
	}

	public void setCitiCode(String citiCode) {
		this.citiCode = citiCode;
	}

	public String getContryCode() {
		return contryCode;
	}

	public void setContryCode(String contryCode) {
		this.contryCode = contryCode;
	}

	private static final long serialVersionUID = 1L;

}
