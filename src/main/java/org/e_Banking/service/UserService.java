package org.e_Banking.service;


import java.security.Principal;

import org.e_Banking.dto.LoginDto;
import org.e_Banking.dto.OtpDto;
import org.e_Banking.dto.ResetPasswordDto;
import org.e_Banking.dto.ResponseDto;
import org.e_Banking.dto.SavingAccountDto;
import org.e_Banking.dto.TransferDto;
import org.e_Banking.dto.UserDto;
import org.e_Banking.dto.depositDto;
import org.e_Banking.dto.loanDto;
import org.e_Banking.entity.BankTransactions;
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
	ResponseEntity<ResponseDto> confirmPayment(Double amount, String razorpay_payment_id, Principal principal);
	ResponseEntity<ResponseDto> transfer(Principal principal, TransferDto dto);
	ResponseEntity<ResponseDto> deposit(Principal principal, depositDto ddto);
	ResponseEntity<ResponseDto> loan(Principal principal, loanDto dto);
    ResponseEntity<ResponseDto> repayloan(Principal principal, loanDto dto);
    ResponseEntity<ResponseDto> viewloan(Principal principal);
    ResponseEntity<ResponseDto> Banktansaction(Principal principal);
}


