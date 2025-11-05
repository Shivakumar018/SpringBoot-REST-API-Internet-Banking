package org.e_Banking.service;


import org.e_Banking.dto.ResponseDto;
import org.e_Banking.dto.UserDto;
import org.e_Banking.entity.TempUser;
import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<ResponseDto> register(UserDto dto);

	String check(String email);
}


