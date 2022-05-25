package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductData {
	static private ArrayList<Product> productList = new ArrayList<Product>();
	
	public void saveProduct(Product product) {
		this.productList.add(product);
	}
	
	public void updateProduct(Product product) {
		for(int i = 0; i < productList.size(); i++) {
			Product listProduct = productList.get(i);
			if(listProduct.getId().equals(product.getId())) {
				productList.set(i, product);
			}
		}
	}
	
	public Product getProductById (String id) {
		for(int i = 0; i < productList.size(); i++) {
			String productId = productList.get(i).getId();
			if(productId.equals(id)) {
				return productList.get(i);
			}
		}
		return null;
	}
	
	public Product getProductBySku (String sku) {
		for(int i = 0; i < productList.size(); i++) {
			String productSku = productList.get(i).getSku();
			if(productSku.equals(sku)) {
				System.out.println("if do data");
				return productList.get(i);
			}
			System.out.println("else do service");
		}
		return null;
	}
	
	public ArrayList<Product> getAllProducts () {
		if(productList != null) {
			return productList;
		}
		return null;
	}
	
	public void deleteProduct(Product product) {
		for(int i = 0; i < productList.size(); i++) {
			Product listProduct = productList.get(i);
			if(listProduct.getId().equals(product.getId())) {
				productList.remove(i);
			}
		}
	}
}
