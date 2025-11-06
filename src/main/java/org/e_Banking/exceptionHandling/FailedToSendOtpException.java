package org.e_Banking.exceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FailedToSendOtpException extends RuntimeException {
	private String message;
}
