package com.example.demoPFE.Exeptions;

import java.text.MessageFormat;

public class demandeExeption extends RuntimeException {
	public demandeExeption(Long iddemande) {
	super(MessageFormat.format("demande not found",iddemande));

}}
