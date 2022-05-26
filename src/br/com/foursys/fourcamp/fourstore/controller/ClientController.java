package br.com.foursys.fourcamp.fourstore.controller;

import br.com.foursys.fourcamp.fourstore.model.Client;
import br.com.foursys.fourcamp.fourstore.service.ClientService;

public class ClientController {
	
	ClientService clientservice = new ClientService();
	
	public boolean clientIsRegistered(String cpf) {
		return clientservice.clientIsRegistered(cpf);
	}
	
	public Client findByCPF(String cpf) {
		return clientservice.findByCPF(cpf);
	}
	
	public void registerClient(String nome, String cpf) {
		Client cliente = new Client(nome, cpf);
		clientservice.registerClient(cliente);
	}

}
