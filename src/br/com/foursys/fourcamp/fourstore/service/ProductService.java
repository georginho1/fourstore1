package br.com.foursys.fourcamp.fourstore.service;

import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductService {
	
	ProductData data = new ProductData();

	public void cadProduct(Product product) {
		data.saveProduct(product);
		
	}
	
	

}
