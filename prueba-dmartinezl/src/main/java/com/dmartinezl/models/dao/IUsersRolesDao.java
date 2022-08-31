package com.dmartinezl.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmartinezl.models.entity.UsersRoles;

public interface IUsersRolesDao extends JpaRepository<UsersRoles, String>{
	
}
