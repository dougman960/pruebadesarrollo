package com.dmartinezl.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.dmartinezl.models.entity.Usuario;
import com.dmartinezl.models.servicesImpl.UsuarioServiceImpl;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		Map<String,Object> info = new HashMap<>();
		
		Usuario usuario = usuarioServiceImpl.findByEmail(authentication.getName().trim());
		
		info.put("User", authentication.getName());
		info.put("Created",usuario.getCreated());
		info.put("Last login", usuario.getLast_login());
		info.put("Modified", usuario.getModified());

		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
