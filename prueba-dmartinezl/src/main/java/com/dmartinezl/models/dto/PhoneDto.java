package com.dmartinezl.models.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PhoneDto implements Serializable {

	@NotNull
	@NotEmpty(message = "it cant be empty")
	private String number;

	@NotNull
	@NotEmpty(message = "it cant be empty")
	private String citycode;

	@NotNull
	@NotEmpty(message = "it cant be empty")
	private String contrycode;

	public PhoneDto() {
	
	}

	public PhoneDto(@NotNull @NotEmpty(message = "it cant be empty") String number,
			@NotNull @NotEmpty(message = "it cant be empty") String citycode,
			@NotNull @NotEmpty(message = "it cant be empty") String contrycode) {
		this.number = number;
		this.citycode = citycode;
		this.contrycode = contrycode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getContrycode() {
		return contrycode;
	}

	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}

	private static final long serialVersionUID = 1L;

}
