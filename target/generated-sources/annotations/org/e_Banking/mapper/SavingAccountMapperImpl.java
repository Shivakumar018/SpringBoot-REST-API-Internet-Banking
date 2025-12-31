package org.e_Banking.mapper;

import javax.annotation.processing.Generated;
import org.e_Banking.dto.SavingAccountResponseDto;
import org.e_Banking.entity.SavingBankAccount;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-01T01:19:27+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
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
        savingAccountResponseDto.setFullName( entity.getFullName() );
        savingAccountResponseDto.setAddress( entity.getAddress() );
        savingAccountResponseDto.setIfscCode( entity.getIfscCode() );
        savingAccountResponseDto.setBalance( entity.getBalance() );

        return savingAccountResponseDto;
    }
}
