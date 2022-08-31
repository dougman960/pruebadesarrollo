package com.dmartinezl.models.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto implements Serializable {

	@NotNull
	@NotEmpty(message = "it cant be empty")
	private String name;

	
	@Email(message="must be a properly formatted email address")
	private String email;

	@Size(min = 3, max = 30)
	private String password;

	@Valid
	private List<PhoneDto> phones;
	


	public UserDto() {
		
	}

	
	
	public UserDto(@NotNull @NotEmpty(message = "it cant be empty") String name, @Email String email,
			@Size(min = 3, max = 30) String password, @Valid List<PhoneDto> phones) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PhoneDto> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDto> phones) {
		this.phones = phones;
	}

	private static final long serialVersionUID = 1L;

}
