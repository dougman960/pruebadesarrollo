package com.dmartinezl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmartinezl.generics.GenericValidPassword;
import com.dmartinezl.models.dto.UserDto;
import com.dmartinezl.models.servicesImpl.UsuarioServiceImpl;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/user/")
public class Controller {
	
	private static final Logger logger = LogManager.getLogger(Controller.class);
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@Autowired
	GenericValidPassword genericValidPassword ;
	
	
	 @ApiOperation(value = "Post method for user creations")
	@PostMapping(value = "/register" , consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	private ResponseEntity<?> save (@Valid @RequestBody UserDto userDto,BindingResult result){
	
		Map<String , Object> response =  new HashMap<>();	
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return "El campo '" + err.getField() + " ' " + err.getDefaultMessage();
			}).collect(Collectors.toList());
			response.put("errors", errors);

			logger.info("error bindig result" + errors);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		 if (genericValidPassword.ValidPassword(userDto.getPassword()) != "Ok" ) {
			 	String mensaje = genericValidPassword.ValidPassword(userDto.getPassword());
			 	response.put("mensaje", mensaje);
				logger.info( mensaje);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		 }
		 
		try {
						
			if (usuarioServiceImpl.findByEmail(userDto.getEmail().trim()) == null) {	
				
				 usuarioServiceImpl.save(userDto);	
							
			}else {
				response.put("Mensaje", "The email " + userDto.getEmail().concat(" already exist"));
				logger.info( "The email " + userDto.getEmail().concat(" already exist"));
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);				
			}
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error inserting into database");
			logger.info("Error inserting into database" + e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		
		response.put("user", "User created successfully");
		return new ResponseEntity<>(response,HttpStatus.CREATED);
		
	}

}
