package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;

import br.com.foursys.fourcamp.fourstore.controller.ProductController;
import br.com.foursys.fourcamp.fourstore.data.SaleData;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Sale;

public class SaleService {
	
	static List<Product> cart;
	ProductController productController = new ProductController();
	
	public void saveSale(Sale sale) {
		SaleData saleData = new SaleData();
		saleData.save(sale);
	}
	
	public List<Sale> listSale() {
		SaleData saleData = new SaleData();
		return saleData.list();
	}
	
	public Double amountValeu(List<Product> products) {
		Double amountValue = 0.0;
		for(int i = 0; i < products.size(); i++) {
			amountValue += products.get(i).getSalePrice();
		}
		return amountValue;
	}
	
	public boolean addCart(String sku, Integer quantity) {
			if(productController.haveStock(sku, quantity)) {
				Product product = productController.getProductBySku(sku);
				cart.add(product);
				return true;
			}
				return false;
	}
	
	public void clearCart() {
		cart.clear();
	}
	
	public List<Product> cart() {
		return cart;
	}

}
