package com.example.demoPFE.Exeptions;

import java.text.MessageFormat;

public class categorieExeption extends RuntimeException {
	public categorieExeption(Long idcategorie) {
	super(MessageFormat.format("cat not found",idcategorie));

}}
