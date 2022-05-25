package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.model.Client;
import interfaces.DataInterfaces;

public class ClientData implements DataInterfaces<Client> {

	ArrayList<Client> clientList = new ArrayList<Client>();

	@Override
	public void save(Client client) {
		if(!this.clientList.contains(client)) {
			this.clientList.add(client);
		}	
	}

	@Override
	public ArrayList<Client> listAll() {
		if(clientList != null) {
			return clientList;
		}
		return null;
	}

	@Override
	public void update(Client client) {
		for (int x = 0; x < this.clientList.size(); x++) {
			if (client.getCpf() == this.clientList.get(x).getCpf()) {
				this.clientList.set(x, client);
			}
		}
	}
	
	@Override
	public void delete(Client client) {
		this.clientList.remove(client);
	}

	public Client findByCPF(String cpf) {
		Client cliente = null;
		for (int x = 0; x < this.clientList.size(); x++) {
			if (cpf == this.clientList.get(x).getCpf()) {
				cliente = this.clientList.get(x);
				return cliente;
			}
		}
		return cliente;
	}

}
