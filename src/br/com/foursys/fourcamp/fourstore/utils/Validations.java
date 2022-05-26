package br.com.foursys.fourcamp.fourstore.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

	public int validationMenu(String entrada, String verificMenu) {
		int option;

		if (entrada.matches(verificMenu)) {
			option = Integer.parseInt(entrada);
			return option;
		} else {
			option = -1;
			return option;
		}

	}

	public boolean validateCard(String acceptedCards) {
		Boolean retorno = false;

		if (acceptedCards.length() != 16 && acceptedCards.length() != 19) {
			return retorno;
		}
		retorno = checkLuhn(acceptedCards);

		return retorno;
	}

	public boolean checkLuhn(String value) {
		value = value.replace(" ", "");
		int sum = 0;
		boolean shouldDouble = false;

		for (int i = value.length() - 1; i >= 0; i--) {
			Integer digit = Integer.parseInt(value.substring(i, i + 1));

			if (shouldDouble) {
				if ((digit *= 2) > 9) {
					digit -= 9;
				}
			}

			sum += digit;
			shouldDouble = !shouldDouble;
		}
		return (sum % 10) == 0;
	}
	public boolean validateCpfregex(String cpf) {
		String pattern = "([0-9]{3}[\\.][0-9]{3}[\\.][0-9]{3}[\\-][0-9]{2})";
		Pattern regex = Pattern.compile(pattern);
		
		Matcher matcher = regex.matcher(cpf);
		
		if(!matcher.matches()) {
			return false;
		}
		return true;

	}
}
