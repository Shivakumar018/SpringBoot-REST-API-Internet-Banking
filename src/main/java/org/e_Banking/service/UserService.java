package org.e_Banking.service;


import org.e_Banking.dto.OtpDto;
import org.e_Banking.dto.ResetPasswordDto;
import org.e_Banking.dto.ResponseDto;
import org.e_Banking.dto.SavingAccountDto;
import org.e_Banking.dto.TransferDto;
import org.e_Banking.dto.UserDto;

import java.security.Principal;
import java.util.Map;

import org.e_Banking.dto.LoginDto;
import org.springframework.http.ResponseEntity;


public interface UserService {

	ResponseEntity<ResponseDto> register(UserDto dto);
	ResponseEntity<ResponseDto> verifyOtp(OtpDto dto);
	ResponseEntity<ResponseDto> resetPassword(ResetPasswordDto dto);
	ResponseEntity<ResponseDto> resendOtp(String email);
	ResponseEntity<ResponseDto> forgotPassword(String email);
	ResponseEntity<ResponseDto> login(LoginDto dto);
	ResponseEntity<ResponseDto> viewSavingsAccount(Principal principal);
	ResponseEntity<ResponseDto> createSavingsAccount(Principal principal, SavingAccountDto accountDto);
	ResponseEntity<ResponseDto> checkBalance(Principal principal);
	ResponseEntity<ResponseDto> deposit(Principal principal, Map<String, Double> map);
	ResponseEntity<ResponseDto> confirmPayment(Double amount, String razorpay_payment_id, Principal principal);
	ResponseEntity<ResponseDto> transfer(Principal principal, TransferDto dto);
}


