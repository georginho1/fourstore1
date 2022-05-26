package br.com.foursys.fourcamp.fourstore.controller;

import br.com.foursys.fourcamp.fourstore.utils.Validations;

public class MenuController {
	private static Validations validations;
	
	public MenuController() {
		validations = new Validations();
		
	}
	public int validationRegexMenu(String entrada, String verificMenu) {
		
		
		return validations.validationMenu(entrada, verificMenu);
		
	}
	
	public boolean validarCpf(String cpf) {
		boolean isValid=validations.cpfValidation(cpf);
		return isValid;
		
	}
	
	public boolean validationCard(String acceptedCards) {
		return validations.validateCard(acceptedCards);
	}
	
		
}
