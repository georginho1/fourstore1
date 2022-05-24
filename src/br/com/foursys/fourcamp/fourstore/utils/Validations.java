package br.com.foursys.fourcamp.fourstore.utils;



public class Validations {

	public int validationMenu(String entrada, String verificMenu) {
		int option;
		
		if(entrada.matches(verificMenu)) {
			option = Integer.parseInt(entrada);
			return option;
		}else {
		option = -1;
		return option;
		}

		
	}
}
