package org.e_Banking.service;

import java.util.List;

import org.e_Banking.entity.User;
import org.e_Banking.dto.BankingRole;
import org.e_Banking.dto.ResponseDto;
import org.e_Banking.entity.BankTransactions;
import org.e_Banking.entity.SavingBankAccount;
import org.e_Banking.exceptionHandling.DataNotFoundException;
import org.e_Banking.mapper.UserMapper;
import org.e_Banking.repository.SavingAccountRepository;
import org.e_Banking.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

	private final SavingAccountRepository savingAccountRepository;
	private final UserRepository userRepository;
	private final UserMapper userMapper;

	@Override
	public ResponseEntity<ResponseDto> getPendingAccounts() {
		List<SavingBankAccount> list = savingAccountRepository.findByActiveFalse();
		if (list.isEmpty())
			throw new DataNotFoundException("No Accounts Pending for Verfication");
		else {
			return ResponseEntity.ok(new ResponseDto("Accounts Found", list));
		}
	}

	@Override
	public ResponseEntity<ResponseDto> getUser(Long accountNumber) {
		User user = userRepository.findByBankAccount_accountNumber(accountNumber)
				.orElseThrow(() -> new DataNotFoundException("No User Details Found"));
		return ResponseEntity.ok(new ResponseDto("User Details Found", userMapper.toDto(user)));
	}

	@Override
	public ResponseEntity<ResponseDto> approveBankAccount(Long accountNumber) {
		SavingBankAccount account = savingAccountRepository.findById(accountNumber)
				.orElseThrow(() -> new DataNotFoundException("No Account Details Found"));
		account.setActive(true);
		savingAccountRepository.save(account);
		return ResponseEntity.ok(new ResponseDto("Account Approved Success", account));
	}
	
	@Override
	public ResponseEntity<ResponseDto> getAlluser() {
		List<User> users = userRepository.findByRole(BankingRole.USER);
		if (users.isEmpty())
			throw new DataNotFoundException("No Users Found");
		else
			return ResponseEntity.ok(new ResponseDto("Users Found", userMapper.toDtoList(users)));
	}

	@Override
	public ResponseEntity<ResponseDto> getBankAccount(String email) {
		User user=userRepository.findByEmail(email);
		if(user==null)
			throw new DataNotFoundException("Invalid Email");
		else {
			SavingBankAccount account=user.getBankAccount();
			if(account!=null && account.isActive())
				return ResponseEntity.ok(new ResponseDto("Account Found", account));
			else
				throw new DataNotFoundException("No Account for the User");
		}
	}

	@Override
	public ResponseEntity<ResponseDto> getBankTransactions(Long accountNumber) {
		SavingBankAccount account=savingAccountRepository.findById(accountNumber).orElseThrow(()->new DataNotFoundException("Invalid Account Number"));
		List<BankTransactions> transactions=account.getBankTransactions();
		if(transactions.isEmpty())
			throw new DataNotFoundException("No Transactions Found");
		else 
			return ResponseEntity.ok(new ResponseDto("Transactions Found", transactions));
	}

	@Override
	public ResponseEntity<ResponseDto> blockAccount(Long accountNumber) {
		SavingBankAccount account=savingAccountRepository.findById(accountNumber).orElseThrow(()->new DataNotFoundException("Invalid Account Number"));
		account.setBlocked(true);
		savingAccountRepository.save(account);
		return ResponseEntity.ok(new ResponseDto("Account Blocked Success", account));
	}

	@Override
	public ResponseEntity<ResponseDto> unblockAccount(Long accountNumber) {
		SavingBankAccount account=savingAccountRepository.findById(accountNumber).orElseThrow(()->new DataNotFoundException("Invalid Account Number"));
		account.setBlocked(false);
		savingAccountRepository.save(account);
		return ResponseEntity.ok(new ResponseDto("Account Blocked Success", account));
	}

	@Override
	public ResponseEntity<ResponseDto> approveLoan(Long accountNumber) {
		SavingBankAccount account = savingAccountRepository.findById(accountNumber)
				.orElseThrow(() -> new DataNotFoundException("No Account Details Found"));
		account.setLoanActive(true);
		savingAccountRepository.save(account);
		return ResponseEntity.ok(new ResponseDto("Loan Approved Success", account));
	}

}
