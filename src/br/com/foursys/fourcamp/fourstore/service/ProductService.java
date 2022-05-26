package br.com.foursys.fourcamp.fourstore.service;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductService {

	private ProductData productData = new ProductData();
	
	public Product getById(String id) {
		return this.productData.getProductById(id);
	}
	
	public Product getBySku(String sku) {
		return this.productData.getProductBySku(sku);
	}
	
	public Boolean updateBySku(String originalSku, Product updatedProduct) {
		if(originalSku == null || updatedProduct == null) return false; 
		
		Product originalProduct = this.productData.getProductBySku(originalSku);
		if(originalProduct == null) return false;
		
		updatedProduct.setId(originalProduct.getId());
		return update(originalProduct, updatedProduct);
	}
	
	public Boolean updateById(String id, Product updatedProduct) {
		if(id == null || updatedProduct == null) return false;
		
		Product originalProduct = this.productData.getProductById(id);
		if(originalProduct == null) return false;
		
		updatedProduct.setId(id);
		return update(originalProduct, updatedProduct);
	}
	
	private Boolean update(Product originalProduct, Product updatedProduct) { 
		if(updatedProduct.getSku() != null) originalProduct.setSku(updatedProduct.getSku());
		
		Integer updatedQuantity = updatedProduct.getQuantity();
		if(updatedQuantity != null) {
			if(updatedQuantity < 0 ) return false;
			originalProduct.setQuantity(updatedQuantity);
		}
		
		Double updatedPurchasePrice = updatedProduct.getPurchasePrice();
		if(updatedPurchasePrice != null) {
			if(updatedPurchasePrice < 0) return false;
			originalProduct.setPurchasePrice(updatedPurchasePrice);
		}
		
		Double updatedSalePrice = updatedProduct.getSalePrice();
		if(updatedSalePrice != null) {
			if(updatedSalePrice < 0) return false;
			originalProduct.setSalePrice(updatedSalePrice);
		}
		
		this.productData.updateProduct(originalProduct);
		return true;
	}
	
	public Boolean deleteProductById(String id) {
		Product product = this.productData.getProductById(id);
		return this.deleteProduct(product);
	}
	
	public Boolean deleteProductBySky(String sku) {
		Product product = this.productData.getProductBySku(sku);
		return this.deleteProduct(product);
	}
	
	private Boolean deleteProduct(Product product) {
		if(product == null) return false;	
		this.productData.deleteProduct(product);
		return true;
	}
	
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
	
	public Boolean haveStock(String sku, Integer quantity) {
		Product productInStock = productData.getProductBySku(sku);
		if(productInStock != null) {
			Integer quantityInStock = productInStock.getQuantity();
			if(quantityInStock >= quantity) {
				return true;
			}
		}

		return false;
	}
}