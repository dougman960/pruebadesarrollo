package com.dmartinezl.models.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmartinezl.models.dao.IUserDao;
import com.dmartinezl.models.dto.UserDto;
import com.dmartinezl.models.entity.Phone;
import com.dmartinezl.models.entity.Role;
import com.dmartinezl.models.entity.Usuario;
import com.dmartinezl.models.services.IUserService;

@Service
public class UsuarioServiceImpl implements IUserService,UserDetailsService{
	
	private static final Logger logger = LogManager.getLogger(UsuarioServiceImpl.class);

	
	@Autowired
	IUserDao iUserDao;
	
	@Autowired
	UsersRolesServiceImpl usersRolesServiceImpl;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	@Transactional
	public Usuario save(UserDto userDto) {
		Usuario usuario = new Usuario();
		String uuid = UUID.randomUUID().toString();
		
		usuario.setId(uuid);
		usuario.setName(userDto.getName().trim());
		usuario.setPassword(passwordEncoder.encode(userDto.getPassword().trim()));
		usuario.setEmail(userDto.getEmail().trim());
		usuario.setEnabled(true);
		usuario.prePersist();
		List<Phone> phones = new ArrayList<>();
		
		for (Integer i = 0 ; i < userDto.getPhones().size(); i ++) {
			Phone phone = new Phone();
			
			phone.setId(uuid);
			phone.setNumber(userDto.getPhones().get(i).getNumber().trim());
			phone.setCitiCode(userDto.getPhones().get(i).getCitycode().trim());
			phone.setContryCode(userDto.getPhones().get(i).getContrycode().trim());
			phones.add(phone);
			
			usuario.setPhone(phones);
		}

		List<Role> role = new ArrayList<>();
		Role roles = new Role ();
		roles.setId((long) 1);
		roles.setName("ROLE_USER");
		role.add(roles);
		
		usuario.setRoles(role);
		
		return iUserDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByEmail(String email) {
		return iUserDao.findByEmail(email);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Usuario usuario = iUserDao.findByEmail(email.trim());
		
		if(usuario == null) {
			logger.error("Error in the login, there is no user '"+email+"' in the system");
			throw new UsernameNotFoundException("Error in the login, there is no user '"+email+"' in the system");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.peek(authority -> logger.info("Role :" + authority.getAuthority()))
				.collect(Collectors.toList());
		
		
		return new User(usuario.getEmail(),usuario.getPassword(),usuario.getEnabled(),true,true,true,authorities);
	}

	@Override
	@Transactional
	public void update(Usuario usuario) {
		 iUserDao.save(usuario);
	}

}
