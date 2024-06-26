package com.multimodule.customControllerException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.multimodule.customExceptionWithinModule.ResourceNotFoundException;

@RestControllerAdvice
public class ControllerException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> resourseException(ResourceNotFoundException exception ,WebRequest request) {
		
		Map<String,Object> mp= new HashMap<>();
		
		mp.put("timeStamp",LocalDateTime.now());
		mp.put("status", HttpStatus.NOT_FOUND.value());
		mp.put("msg", exception.getMessage());
		mp.put("path", request.getDescription(false));
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mp);
		
	}

}
