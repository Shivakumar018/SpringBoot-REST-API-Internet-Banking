package org.e_Banking.service;



import org.e_Banking.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface AdminService {

	ResponseEntity<ResponseDto> getPendingAccounts();

	ResponseEntity<ResponseDto> getUser(Long accountNumber);

	ResponseEntity<ResponseDto> approveBankAccount(Long accountNumber);
	
	ResponseEntity<ResponseDto> getAlluser();

	ResponseEntity<ResponseDto> getBankAccount(String email);

	ResponseEntity<ResponseDto> getBankTransactions(Long accountNumber);

	ResponseEntity<ResponseDto> blockAccount(Long accountNumber);

	ResponseEntity<ResponseDto> unblockAccount(Long accountNumber);

    ResponseEntity<ResponseDto> approveLoan(Long accountNumber);

    ResponseEntity<ResponseDto> getPendingLoan();

}
