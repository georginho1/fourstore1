package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.model.Client;

public class ClientData {

	ArrayList<Client> clientList = new ArrayList<Client>();

	public void createClient(Client client) {
		if(!this.clientList.contains(client)) {
			this.clientList.add(client);
		}	
	}

	public String listAllClient() {
		String retorno = "";
		for (int x = 0; x < this.clientList.size(); x++) {
			retorno = retorno + "\n" + this.clientList.get(x);
		}
		return retorno;
	}

	public void updateClient(Client client) {
		for (int x = 0; x < this.clientList.size(); x++) {
			if (client.getCpf() == this.clientList.get(x).getCpf()) {
				this.clientList.set(x, client);
			}
		}
	}
	
	public void deleteClient(Client client) {
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
