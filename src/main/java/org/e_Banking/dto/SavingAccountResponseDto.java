package org.e_Banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavingAccountResponseDto {
    private Long accountNumber;
    private String fullName;
    private String address;
    private String ifscCode;
    private Double balance;
}
