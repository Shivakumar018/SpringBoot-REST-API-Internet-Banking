package org.e_Banking.mapper;

import javax.annotation.processing.Generated;
import org.e_Banking.dto.SavingAccountResponseDto;
import org.e_Banking.entity.SavingBankAccount;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-21T09:50:26+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250526-2018, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class SavingAccountMapperImpl implements SavingAccountMapper {

    @Override
    public SavingAccountResponseDto toDto(SavingBankAccount entity) {
        if ( entity == null ) {
            return null;
        }

        SavingAccountResponseDto savingAccountResponseDto = new SavingAccountResponseDto();

        savingAccountResponseDto.setAccountNumber( entity.getAccountNumber() );
        savingAccountResponseDto.setAddress( entity.getAddress() );
        savingAccountResponseDto.setBalance( entity.getBalance() );
        savingAccountResponseDto.setFullName( entity.getFullName() );
        savingAccountResponseDto.setIfscCode( entity.getIfscCode() );

        return savingAccountResponseDto;
    }
}
