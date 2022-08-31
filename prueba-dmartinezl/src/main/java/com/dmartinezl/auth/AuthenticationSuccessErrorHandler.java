package com.dmartinezl.auth;



import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.dmartinezl.models.entity.Usuario;
import com.dmartinezl.models.servicesImpl.UsuarioServiceImpl;


@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher{

	private static final Logger log =  LoggerFactory.getLogger(AuthenticationSuccessErrorHandler.class);

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

	
	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {

		if(authentication.getDetails() instanceof WebAuthenticationDetails) {
			return;
		}
		
		UserDetails user = (UserDetails)authentication.getPrincipal();
		
		try {
			Usuario usuario = usuarioServiceImpl.findByEmail(user.getUsername());
			usuario.setLast_login(new Date());
			
			if (usuario.getIntentos() != null) {
				usuario.setIntentos(0);
				log.info("Modify Attempts:" + user.getUsername());

			}
			
			usuarioServiceImpl.update(usuario);
			
		} catch (Exception e) {

			log.error(String.format("User %s does not exist in the system ", user.getUsername()));
		}
		
		
		log.info("Succes Login:" + user.getUsername());
		
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {

		try {
			Usuario usuario = usuarioServiceImpl.findByEmail(authentication.getName());
			 
			if(usuario.getIntentos() == null) {
			
				usuario.setIntentos(0);
			}
				
			usuario.setIntentos(usuario.getIntentos() + 1);
			
			if(usuario.getIntentos() >= 3 ) {
				usuario.setEnabled(false);
				log.error(String.format("User %s does not exist in the system ", authentication.getName()));

			}
			
			usuarioServiceImpl.update(usuario);
			
		} catch (Exception e) {

			log.error(String.format("User %s disabled by maximum attempts ", authentication.getName()));
		}
		
		log.info("Error in Login:" + exception.getMessage());

	}

}
