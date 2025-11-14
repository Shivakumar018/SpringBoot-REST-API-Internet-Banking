package org.e_Banking.repository;


import java.util.List;

import org.e_Banking.entity.SavingBankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingAccountRepository extends JpaRepository<SavingBankAccount, Long> {

	List<SavingBankAccount> findByActiveFalse();

}
