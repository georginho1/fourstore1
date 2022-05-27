package br.com.foursys.fourcamp.fourstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.foursys.fourcamp.fourstore.enums.PaymentMethod;
import br.com.foursys.fourcamp.fourstore.model.Client;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Sale;
import br.com.foursys.fourcamp.fourstore.service.ClientService;
import br.com.foursys.fourcamp.fourstore.service.ProductService;
import br.com.foursys.fourcamp.fourstore.service.SaleService;

public class SaleController {
	
	private SaleService saleService = new SaleService();
	private ClientService clientService = new ClientService();
	
	public String addCart(String sku, Integer quantity) {
		if(saleService.addCart(sku, quantity)) {
			return "\nProduto adicionado com sucesso!\n";
		}
		return "\nO produto nao pode ser adicionado\n";
	}
	
	public String clearCart() {
		saleService.clearCart();
		return "Carrinho limpo";
	}
	
	public List<Product> cart() {
		return saleService.cart();
	}
	
	public String saleRegister(PaymentMethod paymentmethod, String cpf) {
		ArrayList<Product> cart = SaleService.getCart(); //lista de produtos da compra
		Client client = clientService.findByCPF(cpf); //Cliente da compra
		Double amountValue = this.amountValue(cart); //valor da compra
		
		Sale sale = new Sale(client, cart, amountValue, paymentmethod);
		
		saleService.saveSale(sale);
		
		return "\nVenda realizada com sucesso\n" + sale;
	}
	
	public String saleRegister(PaymentMethod paymentmethod) {
		ArrayList<Product> cart = SaleService.getCart(); //lista de produtos da compra
		Double amountValue = this.amountValue(cart); //valor da compra
		
		Sale sale = new Sale(cart, amountValue, paymentmethod);
		
		saleService.saveSale(sale);
		
		return "\nVenda realizada com sucesso\n" + sale;
	}
	
	
	public String saleConsultation() {
		String retorno = "";
		if(saleService.listSale().size() == 0) {
			retorno = "\nNão há historico de vendas!\n";
			return retorno;
		}
		retorno = saleService.listSale().toString();
		return retorno;
	}
	
	public Double amountValue(List<Product> products) {
		Double retorno = 0.0;
		retorno = saleService.amountValue(products);
		return retorno;
	}
}
