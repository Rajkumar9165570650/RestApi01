package com.raj.exception;



import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobelExcetion {
	
	@ExceptionHandler(StudentResourse.class)
	public ResponseEntity<ErrroPage> custom(StudentResourse ex){
		ErrroPage e=new ErrroPage(ex.getMessage(),LocalTime.now(), HttpStatus.NOT_FOUND.value());
		return ResponseEntity.ok(e);	
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrroPage> predefind(Exception ex){
		ErrroPage e=new ErrroPage(ex.getMessage(),LocalTime.now(),HttpStatus.INTERNAL_SERVER_ERROR.value());
		return ResponseEntity.ok(e);	
	}
	

}
