package com.multimodule.customExceptionWithinModule;

@SuppressWarnings("serial")
public class ResourceNotFoundException  extends RuntimeException{

	public ResourceNotFoundException(String str) {
		// TODO Auto-generated constructor stub
		
		super(str);
	}
	
}
