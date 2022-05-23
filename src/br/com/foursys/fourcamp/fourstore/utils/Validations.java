package br.com.foursys.fourcamp.fourstore.utils;

import java.util.Scanner;

public class Validations {

	public int validationMenu(String entrada) {
		int option;
		//String entrada;
		
		//Scanner sc = new Scanner(System.in);
		//entrada = sc.nextLine();
		
		if(entrada.matches("[0-6]")) {
			option = Integer.parseInt(entrada);
			return option;
		}else {
		option = -1;
		return option;
		}

		
	}
}
