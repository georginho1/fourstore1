package br.com.foursys.fourcamp.fourstore.data;

import java.util.List;

import br.com.foursys.fourcamp.fourstore.model.Sale;

public class SaleData {
	
	private List<Sale> saleList;
	
	public void save(Sale sale) {
		saleList.add(sale);
	}
	
	public List<Sale> list() {
		return saleList;
	}

}


