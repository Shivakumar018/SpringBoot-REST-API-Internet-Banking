package org.e_Banking.exceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExpiredException extends RuntimeException{
	private String message;
}
