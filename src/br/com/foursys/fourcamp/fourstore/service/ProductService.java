package br.com.foursys.fourcamp.fourstore.service;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductService {
	
	public String listProductService() {
		String retorno = "";
		ArrayList<Product> lista = new ArrayList<Product>();
		ProductData productData = new ProductData();
		lista = productData.getAllProducts();
		for (Product list : lista) {
			retorno += list.toString();
		}
		return retorno;
	}
}
