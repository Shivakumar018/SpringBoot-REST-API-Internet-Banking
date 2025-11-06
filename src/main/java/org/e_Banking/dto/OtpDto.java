package org.e_Banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OtpDto {
	private int otp;
	private String email;
}
