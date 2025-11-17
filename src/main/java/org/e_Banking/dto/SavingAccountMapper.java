package org.e_Banking.dto;

import org.e_Banking.entity.SavingBankAccount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SavingAccountMapper {

	SavingAccountResponseDto toDto(SavingBankAccount entity);
}
