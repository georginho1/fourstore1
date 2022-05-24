package br.com.foursys.fourcamp.fourstore.service;

import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductService {
	
	ProductData data = new ProductData();
	
	public Boolean haveStock(Product purchaseProduct, Integer purchaseQuantity) {
		String purchaseProductId = purchaseProduct.getId();
		Product productInStock = data.getProductById(purchaseProductId);
		
		if(productInStock != null) {
			Integer quantityInStock = productInStock.getQuantity();
			if(quantityInStock >= purchaseQuantity) {
				return true;
			}
		}

		return false;
		
	}
}
