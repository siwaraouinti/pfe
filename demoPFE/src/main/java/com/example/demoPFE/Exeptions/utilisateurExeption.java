package com.example.demoPFE.Exeptions;

import java.text.MessageFormat;

public class utilisateurExeption extends RuntimeException {
	public utilisateurExeption (Long idutilisateur) {
		super(MessageFormat.format("utilisateur not found", idutilisateur));
	}

}
