package br.com.foursys.fourcamp.fourstore.service;

import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductService {
	
	ProductData data = new ProductData();

	public void cadProduct(Product product) {
		data.saveProduct(product);
	}
	
	
	public boolean productIsRegistered(String sku) {
		Boolean retorno = data.getProductById(sku);
		if(data.getProductBySku(sku) == null) {
			System.out.println("if do service");
			return false;
		}
		System.out.println("else do service");
		return true;
	}

}
