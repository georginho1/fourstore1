package br.com.foursys.fourcamp.fourstore;

import br.com.foursys.fourcamp.fourstore.communication.MainMenu;
import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class Application {

	public static void main(String[] args) {
		MainMenu menu = new MainMenu();

		Product produtos = new Product("10321130300050", 10, 25.00, 50.00);
		
		ProductData bancoProduto = new ProductData();
		bancoProduto.saveProduct(produtos);
		
		menu.mainMenu();
		
	}

}