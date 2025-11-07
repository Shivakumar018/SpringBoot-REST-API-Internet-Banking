package org.e_Banking.service;


import org.e_Banking.dto.OtpDto;
import org.e_Banking.dto.ResetPasswordDto;
import org.e_Banking.dto.ResponseDto;
import org.e_Banking.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<ResponseDto> register(UserDto dto);
	ResponseEntity<ResponseDto> verifyOtp(OtpDto dto);
	ResponseEntity<ResponseDto> resetPassword(ResetPasswordDto dto);
	ResponseEntity<ResponseDto> resendOtp(String email);
	ResponseEntity<ResponseDto> forgotPassword(String email);
}


