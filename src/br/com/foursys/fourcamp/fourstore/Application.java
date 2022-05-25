package br.com.foursys.fourcamp.fourstore;

import br.com.foursys.fourcamp.fourstore.communication.MainMenu;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class Application {

	public static void main(String[] args) {
//		MainMenu menu = new MainMenu();
//
//		menu.mainMenu();
		Product product = new Product("14331160909251", 10, 50.0, 100.0);
		
		System.out.println(product);
	}

}
