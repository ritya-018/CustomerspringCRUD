package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.InvalidId;
import com.example.demo.exception.InvaslidMovileNumber;

@ControllerAdvice
public class GlobalExeptionHandlar {

	@ExceptionHandler(InvaslidMovileNumber.class)
	public ResponseEntity<?>invalidMobileNumber(InvaslidMovileNumber e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidId.class)
	public ResponseEntity<?>invalidId(InvalidId i){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(i.getMessage());
	}
}
