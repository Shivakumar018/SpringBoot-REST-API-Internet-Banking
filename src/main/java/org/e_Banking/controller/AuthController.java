package org.e_Banking.controller;


import org.e_Banking.dto.OtpDto;
import org.e_Banking.dto.ResponseDto;
import org.e_Banking.dto.UserDto;
import org.e_Banking.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

	private final UserService userService;

	@PostMapping("/register")
	public ResponseEntity<ResponseDto> register(@RequestBody @Valid UserDto dto) {
		return userService.register(dto);
	}
	
	@PostMapping("/verify-otp")
	public ResponseEntity<ResponseDto> verfiyOtp(@RequestBody OtpDto dto) {
		return userService.verifyOtp(dto);
	}

}

