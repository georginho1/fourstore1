package br.com.foursys.fourcamp.fourstore.service;

import java.util.ArrayList;
import java.util.List;

import br.com.foursys.fourcamp.fourstore.controller.ProductController;
import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.data.SaleData;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Sale;

public class SaleService {
	
	static ArrayList<Product> cart = new ArrayList<Product>();
	ProductController productController = new ProductController();
	ProductData productdata = new ProductData();
	
	public void saveSale(Sale sale) {
		SaleData saleData = new SaleData();
		saleData.save(sale);
	}
	
	public List<Sale> listSale() {
		SaleData saleData = new SaleData();
		return saleData.list();
	}
	
	public Double amountValue(List<Product> products) {
		Double amountValue = 0.0;
		for(int i = 0; i < products.size(); i++) {
			amountValue += products.get(i).getSalePrice();
		}
		return amountValue;
	}
	
	public boolean addCart(String sku, Integer quantity) {
		Product currentProduct = productController.getProductBySkuObject(sku);

		cart.add(currentProduct);
		return true;

	}
	
	public void clearCart() {
		cart.clear();
	}
	
	public List<Product> cart() {
		return cart;
	}

	public static ArrayList<Product> getCart() {
		return cart;
	}
	
	

}
