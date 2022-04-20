package com.example.demoPFE.Exeptions;

import java.text.MessageFormat;

public class notificationExeption extends RuntimeException {
	public notificationExeption (Long idnotif) {
		super(MessageFormat.format("notification not found",idnotif));
		
	
	}
}
