package br.com.foursys.fourcamp.fourstore.controller;

import java.util.List;

import br.com.foursys.fourcamp.fourstore.enums.PaymentMethod;
import br.com.foursys.fourcamp.fourstore.model.Client;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Sale;
import br.com.foursys.fourcamp.fourstore.service.SaleService;

public class SaleController {
	
	SaleService saleService = new SaleService();
	
	public String saleRegister(Client client, List<Product> products, Double amountValue, PaymentMethod paymentMethod) {
		String retorno = "";
		
		
		Sale sale = new Sale(client, products, amountValue, paymentMethod);
		
		//verificarEstoque(List<products>) em service
		
		saleService.saveSale(sale);
		retorno = "Venda registrada com sucesso!";
		return retorno;
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

}
