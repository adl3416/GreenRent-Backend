package com.greenrent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //Bunu geri döndürmesi lazim buda  @ResponseStatus ile oluyor
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
		super(message);
		//TODO Auto-generated constructor stub
	}
	 

}