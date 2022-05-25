package br.com.foursys.fourcamp.fourstore.controller;

import br.com.foursys.fourcamp.fourstore.service.ProductService;

public class ProductController {
	ProductService productService = new ProductService();
	
	public String listProducts() {
		return productService.listProductService();
	}

}
