package org.e_Banking.service;


import org.e_Banking.dto.UserDto;
import org.e_Banking.entity.TempUser;
import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<TempUser> register(UserDto dto);

	ResponseEntity<TempUser> fetch(String email);
	
}


