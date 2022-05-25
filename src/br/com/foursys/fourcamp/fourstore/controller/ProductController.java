package br.com.foursys.fourcamp.fourstore.controller;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.service.ProductService;

public class ProductController {
	
	ProductService service = new ProductService();
	//excluir
	ProductData dataTeste = new ProductData();
	
	public String cadProduct(String sku, String description, String type, String size, String color, String category,
			String season, Integer quantity, Double purchasePrice, Double salePrice) {
		
		String retorno = "";
		
		Product product = new Product(sku, description, type, size, color, 
				category, season, quantity, purchasePrice, salePrice);
		
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
					+ "\n Preço de Venda: " + product.getSalePrice();
			
			service.cadProduct(product);
			ArrayList<Product> listaProdutos = dataTeste.getAllProducts();
			if(listaProdutos.size() != 0) {
				for (int i=0; i<listaProdutos.size(); i++) {
					System.out.println(listaProdutos.get(i) + "\n");
				}
			}
			else {
				System.out.println("Lista sem produtos");
			}
		}
		
		return retorno;
	}

}
