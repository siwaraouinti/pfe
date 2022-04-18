package com.example.demoPFE.Exeptions;

import java.text.MessageFormat;

public class roleExeption extends RuntimeException {
	public roleExeption (Long idrole) {
		super(MessageFormat.format("role not found",idrole));
		
	}

}
