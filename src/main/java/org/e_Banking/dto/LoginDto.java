package org.e_Banking.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LoginDto {
	@NotNull(message = "Email is Required")
	@Email(message = "Invalid Password!!! Enter Proper Email Address")
	private String email;
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$", message = "Invalid Password!!! Enter proper password")
	private String password;
}
