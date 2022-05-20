package br.com.foursys.fourcamp.fourstore.controller;

import br.com.foursys.fourcamp.fourstore.model.Sale;
import br.com.foursys.fourcamp.fourstore.service.SaleService;

public class SaleController {
	
	SaleService saleService = new SaleService();
	
	public String saleRegister(Sale sale) {
		String retorno = "";
		saleService.saveSale(sale);
		retorno = "Venda registrada com sucesso!";
		return retorno;
	}
	
	public String saleConsultation() {
		String retorno = "";
		if(saleService.listSale() == null) {
			retorno = "Não há nunhum histórico de vendas!";
			return retorno;
		}
		retorno = saleService.listSale().toString();
		return retorno;
	}

}
