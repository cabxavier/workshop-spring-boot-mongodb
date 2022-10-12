package com.cabx.workshopmongo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cabx.workshopmongo.domain.User;
import com.cabx.workshopmongo.dto.UserDTO;
import com.cabx.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<User> list = service.findAll();
		List<UserDTO> listDto = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			
			listDto.add(new UserDTO(list.get(i)));
		}
		
		return ResponseEntity.ok().body(listDto);
	}
}
