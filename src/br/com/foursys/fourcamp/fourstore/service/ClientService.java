package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;

import br.com.foursys.fourcamp.fourstore.data.ClientData;
import br.com.foursys.fourcamp.fourstore.model.Client;

public class ClientService {
	
	ClientData clientData = new ClientData();
	
	
	public boolean clientIsRegistered(String cpf) {
		if(clientData.findByCPF(cpf) != null) {
			return true;
		}	
		return false;
	}
	
	public Client findByCPF(String cpf) {
		return clientData.findByCPF(cpf);
	}
	
	public void registerClient(Client client) {
		clientData.save(client);
		}

	public void registerPix(String pixKey) {
		Client client = new Client(pixKey);
		clientData.save(client);
	}

	public void registerPix(String pixKey, String cpf) {
		Client client = clientData.findByCPF(cpf);
		client.setPixKey(pixKey);		
	}
	
	public List<Client> listAll(){
		return clientData.listAll();
	}

}