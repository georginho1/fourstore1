package br.com.foursys.fourcamp.fourstore.controller;

import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.service.ProductService;

public class ProductController {
	
	ProductService service = new ProductService();
	
	public String cadProduct(String sku, String description, 
			Integer quantity, Double purchasePrice, Double salePrice) {
		
		String retorno = "";
		
		Product product = new Product(sku, description, quantity, purchasePrice, salePrice);
		
		if(product == null) {
			retorno = "Não foi possivel cadastrar o produto";
		} else {
				retorno = "O produto foi cadastrado com sucesso."
						+ "\n SKU: " + product.getSku()
						+ "\n ID: " + product.getId()
						+ "\n Descrição: " + product.getDescription()
						+ "\n Tipo: " + product.getType()
						+ "\n Tamanho: " + product.getSize()
						+ "\n Cor: " + product.getColor()
						+ "\n Categotia: " + product.getCategory()
						+ "\n Estação: " + product.getSeason()
						+ "\n Quantidade: " + product.getQuantity()
						+ "\n Preço de Compra: " + product.getPurchasePrice()
						+ "\n Preço de Venda: " + product.getSalePrice() + "\n";
				service.cadProduct(product);
			}
		
		return retorno;
	}
	
	public Boolean productIsRegistered(String sku) {
		if(service.productIsRegistered(sku)) {
			return true;
		}
		else {
			return false;
		}
	}

}
