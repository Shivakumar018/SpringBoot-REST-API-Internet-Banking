package org.e_Banking.controller;

import org.e_Banking.dto.ResponseDto;
import org.e_Banking.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {

	private final AdminService adminService;

	@GetMapping("/banks/pending")
	public ResponseEntity<ResponseDto> getPendingAccounts() {
		return adminService.getPendingAccounts();
	}

	@GetMapping("/loan/pending")
	public ResponseEntity<ResponseDto> getPendingloan() {
		return adminService.getPendingLoan();
	}

	@GetMapping("/user/{accountNumber}")
	public ResponseEntity<ResponseDto> getUser(@PathVariable Long accountNumber) {
		return adminService.getUser(accountNumber);
	}

	@PatchMapping("/approve/saving/{accountNumber}")
	public ResponseEntity<ResponseDto> approveAccount(@PathVariable Long accountNumber) {
		return adminService.approveBankAccount(accountNumber);
	}

	@GetMapping("/users")
	public ResponseEntity<ResponseDto> getAllUsers() {
		return adminService.getAlluser();
	}

	@GetMapping("/bank/{email}")
	public ResponseEntity<ResponseDto> getBankAccount(@PathVariable String email) {
		return adminService.getBankAccount(email);
	}

	@GetMapping("/transactions/{accountNumber}")
	public ResponseEntity<ResponseDto> getBankTransactions(@PathVariable Long accountNumber) {
		return adminService.getBankTransactions(accountNumber);
	}

	@PatchMapping("/block/{accountNumber}")
	public ResponseEntity<ResponseDto> blockAccount(@PathVariable Long accountNumber) {
		return adminService.blockAccount(accountNumber);
	}

	@PatchMapping("/unblock/{accountNumber}")
	public ResponseEntity<ResponseDto> unblockAccount(@PathVariable Long accountNumber) {
		return adminService.unblockAccount(accountNumber);
	}

	@PatchMapping("/approve/loan/{accountNumber}")
	public ResponseEntity<ResponseDto> approveLoan(@PathVariable Long accountNumber) {
		return adminService.approveLoan(accountNumber);
	}
}
