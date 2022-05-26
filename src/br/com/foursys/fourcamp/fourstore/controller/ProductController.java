package br.com.foursys.fourcamp.fourstore.controller;

import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.service.ProductService;

public class ProductController {
	ProductService productService = new ProductService();
	
	public String listProducts() {
		return productService.listProductService();
	}
	
	public Boolean haveStock(String sku, Integer quantity) {
		return productService.haveStock(sku, quantity);
	}
	
	public Product getProductBySku (String sku) {
		return productService.getProductBySku(sku);
	}

}
