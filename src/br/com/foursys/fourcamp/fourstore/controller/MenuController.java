package br.com.foursys.fourcamp.fourstore.controller;

import br.com.foursys.fourcamp.fourstore.utils.Validations;

public class MenuController {

	public int validationRegexMenu(String entrada, String verificMenu) {
		
		Validations validations = new Validations();
		return validations.validationMenu(entrada, verificMenu);
		
	}
		
}
