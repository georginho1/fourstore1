package br.com.foursys.fourcamp.fourstore.service;

import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductService {
	
	ProductData data = new ProductData();
	
	public Boolean haveStock(String sku, Integer quantity) {
		
		Product productInStock = data.getProductBySku(sku);
		
		if(productInStock != null) {
			Integer quantityInStock = productInStock.getQuantity();
			if(quantityInStock >= quantity) {
				return true;
			}
		}

		return false;
		
	}
}
