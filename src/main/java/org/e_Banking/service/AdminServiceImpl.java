package org.e_Banking.service;

import java.util.List;

import org.e_Banking.entity.User;
import org.e_Banking.dto.ResponseDto;
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

}
