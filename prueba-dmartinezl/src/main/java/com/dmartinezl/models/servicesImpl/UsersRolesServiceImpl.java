package com.dmartinezl.models.servicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmartinezl.models.dao.IUsersRolesDao;
import com.dmartinezl.models.entity.UsersRoles;
import com.dmartinezl.models.services.IUsersRolesService;

@Service
public class UsersRolesServiceImpl implements IUsersRolesService{

	@Autowired
	IUsersRolesDao iUsersRolesDao;
	
	@Override
	@Transactional
	public UsersRoles save(String Id) {
		
		UsersRoles usersRoles = new UsersRoles();
		
		usersRoles.setUser_id(Id);
		usersRoles.setRole_id((long) 1);
		
		return iUsersRolesDao.save(usersRoles);
	}

}
