package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.model.Client;

public class ClientData {

	static ArrayList<Client> clientList = new ArrayList<Client>();

	public void createClient(Client client) {
		if(!clientList.contains(client)) {
			clientList.add(client);
		}	
	}

	public String listAllClient() {
		String retorno = "";
		for (int x = 0; x < clientList.size(); x++) {
			retorno = retorno + "\n" + clientList.get(x);
		}
		return retorno;
	}

	public void updateClient(Client client) {
		for (int x = 0; x < clientList.size(); x++) {
			if (client.getCpf() == clientList.get(x).getCpf()) {
				clientList.set(x, client);
			}
		}
	}
	
	public void deleteClient(Client client) {
		clientList.remove(client);
	}

	public Client findByCPF(String cpf) {
		Client cliente = null;
		for (int x = 0; x < clientList.size(); x++) {
			if (cpf == clientList.get(x).getCpf()) {
				cliente = clientList.get(x);
				return cliente;
			}
		}
		return cliente;
	}

}
