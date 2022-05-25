package br.com.foursys.fourcamp.fourstore.controller;

import java.util.ArrayList;
import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.service.ProductService;

public class ProductController {

	public ArrayList<Product> listProducts() {
		ProductService productService = new ProductService();
		return productService.listProductService();
	}

}
