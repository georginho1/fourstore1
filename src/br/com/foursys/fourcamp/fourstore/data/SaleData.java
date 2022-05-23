package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.model.Sale;

public class SaleData {
	
	private static ArrayList<Sale> saleList = new ArrayList<Sale>();
	
	public void save(Sale sale) {
		saleList.add(sale);
	}
	
	public ArrayList<Sale> list() {
			return saleList;
	}
}
