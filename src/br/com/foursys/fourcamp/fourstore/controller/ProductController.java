package br.com.foursys.fourcamp.fourstore.controller;


import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.service.ProductService;


public class ProductController {
	private static ProductService productService = new ProductService();;
	
	public String getProductById(String id) {
		Product product = productService.getById(id);
		if(product == null) return "Não existe um produto com o id " + id;
		return product.toString();
	}
	
	public String getProductBySku(String sku) {
		Product product = productService.getBySku(sku);
		if(product == null) return "Não existe um produto com o sku " + sku;
		return product.toString();
	}
	
	public String deleteProductById(String id) {
		if(productService.deleteProductById(id)) return "Produto excluído!";
		return "Não existe um produto com o id " + id;
	}
	
	public String deleteProductBySku(String sku) {
		if(productService.deleteProductById(sku)) return "Produto excluído!";
		return "Não existe um produto com o sku " + sku;
	}
	
	public String updateProductBySku(String Sku, Integer quantity, Double purchasePrice, Double salePrice) {
		Product product = new Product(Sku, quantity, purchasePrice, salePrice);
		return (productService.updateBySku(product)) ? "Produto alterado com sucesso!" : "Dados inválidos! O produto não foi alterado.";
	}
	
	public String updateProductById(String id, Integer quantity, Double purchasePrice, Double salePrice) {
		Product oldProduct = productService.getById(id);
		String sku = oldProduct.getSku();
		Product product = new Product(sku, quantity, purchasePrice, salePrice);
		return (productService.updateBySku(product)) ? "Produto alterado com sucesso!" : "Dados inválidos! O produto não foi alterado.";
	}
	
	public String listProducts() {
		return productService.listProductService();
	}
	
	public Boolean haveStock(String sku, Integer quantity) {
		return productService.haveStock(sku, quantity);
	}
	
	public Product getProductBySkuObject(String sku) {
		return productService.getProductBySkuObject(sku);
	}

}
