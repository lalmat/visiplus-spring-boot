package com.lalmat.fia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -5495861734422076127L;
}
