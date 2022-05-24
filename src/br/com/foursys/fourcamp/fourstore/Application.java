package br.com.foursys.fourcamp.fourstore;

import br.com.foursys.fourcamp.fourstore.communication.MainMenu;
import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class Application {

	public static void main(String[] args) {
		//MainMenu menu = new MainMenu();

		Product teste1 = new Product("14331160909251", "Camiseta do Batman", 48, 48.50, 92.80);
		Product teste2 = new Product("15342230609352", "Camiseta do Aquamen", 95, 38.50, 62.80);
		Product teste3 = new Product("16333330609454", "Camiseta do Flesh", 27, 25.50, 42.80);
		Product teste4 = new Product("16333330609454", "Camiseta do Flesh", 35, 25.50, 45.90);
		

		
		//TESTES

		ProductData dbProduct = new ProductData();
		dbProduct.saveProduct(teste1);
		dbProduct.saveProduct(teste2);
		dbProduct.saveProduct(teste3);
		dbProduct.updateProduct(teste4);
		System.out.println(dbProduct.getAllProducts());
		
		



		


	}

}
