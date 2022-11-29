package com.xib.assessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.xib.assessment.dto.DataResponse;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> handleNotFoundException(NotFoundException notFoundException){
		log.error("NotFoundException:{}",notFoundException.getMessage());
		return new ResponseEntity<DataResponse>(
				new DataResponse(false, null, notFoundException.getMessage())
				,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception exception){
		log.error("Exception:{}",exception.getMessage());
		return new ResponseEntity<DataResponse>(
				new DataResponse(false, null, exception.getMessage())
				,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
