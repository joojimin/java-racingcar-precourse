package exception;

import type.ExceptionMessage;

public class RacingGameException extends RuntimeException{

	public RacingGameException(final ExceptionMessage exceptionMessage){
		super(exceptionMessage.getMessage());
	}
}
