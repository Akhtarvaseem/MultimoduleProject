package com.multimodule.customExceptionWithinModule;

@SuppressWarnings("serial")
public class IdNotFoundCustomException extends RuntimeException{
	
public IdNotFoundCustomException (String str) {
	
	super(str);
}

}
