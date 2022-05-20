package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;

import br.com.foursys.fourcamp.fourstore.data.SaleData;
import br.com.foursys.fourcamp.fourstore.model.Sale;

public class SaleService {
	
	public boolean saveSale(Sale sale) {
		SaleData saleData = new SaleData();
		saleData.save(sale);
		return true;
	}
	
	public List<Sale> listSale() {
		SaleData saleData = new SaleData();
		return saleData.list();
	}

}
