package br.com.foursys.fourcamp.fourstore.controller;

import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.service.ProductService;

public class ProductController {
	private ProductService productService;
	
	public ProductController() {
		this.productService = new ProductService();
	}

	public String getProductById(String id) {
		Product product = this.productService.getById(id);
		if(product == null) return "Não existe um produto com o id " + id;
		return product.toString();
	}
	
	public String getProductBySku(String sku) {
		Product product = this.productService.getBySku(sku);
		if(product == null) return "Não existe um produto com o sku " + sku;
		return product.toString();
	}
	
	public String deleteProductById(String id) {
		if(this.productService.deleteProductById(id)) return "Produto excluído!";
		return "Não existe um produto com o id " + id;
	}
	
	public String deleteProductBySku(String sku) {
		if(this.productService.deleteProductById(sku)) return "Produto excluído!";
		return "Não existe um produto com o sku " + sku;
	}
	
	public String updateProductBySku(String originalSku, String newSku, String description, Integer quantity, Double purchasePrice, Double salePrice) {
		Product product = new Product(newSku, description, quantity, purchasePrice, salePrice);
		return (this.productService.updateBySku(originalSku, product)) ? "Produto alterado com sucesso!" : "Dados inválidos! O produto não foi alterado.";
	}
	
	public String updateProductById(String id, String sku, String description, Integer quantity, Double purchasePrice, Double salePrice) {
		Product product = new Product(sku, description, quantity, purchasePrice, salePrice);
		return (this.productService.updateById(id, product)) ? "Produto alterado com sucesso!" : "Dados inválidos! O produto não foi alterado.";
	}
	
}
