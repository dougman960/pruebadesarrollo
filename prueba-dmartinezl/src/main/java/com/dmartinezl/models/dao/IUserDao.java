package com.dmartinezl.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dmartinezl.models.entity.Usuario;

public interface IUserDao extends JpaRepository<Usuario, String>{
	
	public Usuario findByEmail(String email);

}
