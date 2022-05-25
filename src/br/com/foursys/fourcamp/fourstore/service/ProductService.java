package br.com.foursys.fourcamp.fourstore.service;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductService {
	
	public ArrayList<Product> listProductService() {
		ProductData productData = new ProductData();
		return productData.getAllProducts();
	}
}
