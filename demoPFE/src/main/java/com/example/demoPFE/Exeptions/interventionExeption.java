package com.example.demoPFE.Exeptions;

import java.text.MessageFormat;

public class interventionExeption extends RuntimeException {
	public interventionExeption(Long idintervention) {
		super(MessageFormat.format("intervention not found", idintervention));
	}

}
