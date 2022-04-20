package com.example.demoPFE.Exeptions;

import java.text.MessageFormat;

public class equipementExeption  extends RuntimeException {
	public equipementExeption (Long idequipement) {
		super(MessageFormat.format("equipement not found",idequipement));
		
	}

}
