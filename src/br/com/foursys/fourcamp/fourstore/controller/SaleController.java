package br.com.foursys.fourcamp.fourstore.controller;

import java.util.List;

import br.com.foursys.fourcamp.fourstore.enums.PaymentMethod;
import br.com.foursys.fourcamp.fourstore.model.Client;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Sale;
import br.com.foursys.fourcamp.fourstore.service.SaleService;

public class SaleController {
	
	SaleService saleService = new SaleService();
	
	public String addCart(Product product) {
		if(product == null) {
			return "O produto não pode ser adicionado";
		}
		saleService.addCart(product);
		return "Produto adicionado com sucesso!";
	}
	
	public String clearCart() {
		saleService.clearCart();
		return "Carrinho limpo";
	}
	
	public String saleRegister(List<Product> products, Double amountValue, PaymentMethod paymentMethod) {
		String retorno = "";
		if(products != null && amountValue != null && paymentMethod != null) { // trocar
			Sale sale = new Sale(products, amountValue, paymentMethod);
			//verificarEstoque(List<products>) em service
			saleService.saveSale(sale);
			retorno = sale.toString();
			return retorno;
		} else {
			return "Não foi possível registrar a venda";
		}
	}
	
	public String saleRegister(Client client, List<Product> products, Double amountValue, PaymentMethod paymentMethod) {
		String retorno = "";
		if(client != null && products != null && amountValue != null && paymentMethod != null) { // trocar
			Sale sale = new Sale(client, products, amountValue, paymentMethod);
			//verificarEstoque(List<products>) em service
			saleService.saveSale(sale);
			retorno = sale.toString();
			return retorno;
		} else {
			return "Não foi possível registrar a venda";
		}
	}
	
	public String saleConsultation() {
		String retorno = "";
		if(saleService.listSale().size() == 0) {
			retorno = "Não há nunhum histórico de vendas!";
			return retorno;
		}
		retorno = saleService.listSale().toString();
		return retorno;
	}
	
	public Double amountValeu(List<Product> products) {
		Double retorno = 0.0;
		retorno = saleService.amountValeu(products);
		return retorno;
	}

}
