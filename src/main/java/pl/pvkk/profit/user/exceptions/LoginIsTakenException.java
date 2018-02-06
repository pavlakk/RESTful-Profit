package pl.pvkk.profit.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class LoginIsTakenException extends RuntimeException {

	private String message;

	public LoginIsTakenException() {
		this.message = "Your login is taken.";
	}

	public String getMessage() {
		return message;
	}
}