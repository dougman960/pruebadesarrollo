package com.dmartinezl.models.services;


import com.dmartinezl.models.dto.UserDto;
import com.dmartinezl.models.entity.Usuario;

public interface IUserService {
	
	public Usuario save (UserDto userDto);
	
	public Usuario findByEmail(String email);
	
	public void update(Usuario usuario);

}
