package br.com.foursys.fourcamp.fourstore.communication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.controller.ClientController;
import br.com.foursys.fourcamp.fourstore.controller.MenuController;
import br.com.foursys.fourcamp.fourstore.controller.SaleController;
import br.com.foursys.fourcamp.fourstore.enums.PaymentMethod;
import br.com.foursys.fourcamp.fourstore.model.Client;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class MainMenu {
	private Scanner scanner;
	private MenuController menucontroller;
	private SaleController salecontroller;
	private ClientController clientcontroller;
	
	public MainMenu() {
		this.menucontroller = new MenuController();
		this.scanner = new Scanner(System.in);
		this.salecontroller = new SaleController();
		this.clientcontroller = new ClientController();
	}

	public void mainMenu() {

		primaryMenu();

	}

	private void primaryMenu() {

		Integer option = -1;
		String entrada;

		while (option != 0) {
			System.out.println("==========FOURSTORE=============||");
			System.out.println("1 - Produtos                    ||");
			System.out.println("2 - Vendas                      ||");
//			System.out.println("3 - Clientes                    ||");
			System.out.println("0 - Sair do sistema             ||");
			System.out.print("Insira uma op��o: ");
			entrada = scanner.nextLine();
			System.out.println("----------------------------------\n");

			option = menucontroller.validationRegexMenu(entrada, "[0-6]");

			switch (option) {
			case 0:
				System.out.println("\nSistema encerrado");
				break;
			case 1:
				this.menuProducts();
				break;
			case 2:
				this.menuSales();
				break;
//				case 3:
//					this.menuClients();
//					break;
			default:
				System.out.println("\nOpcao Invalida. Tente Novamente. \n");
			}
		}
	}

	private void menuSales() {
		int option = -1;
		String entrada;

		while (option != 0) {
			System.out.println("1 - Realizar Venda" + "\n2 - Consultar uma venda" + "\n0 - Para voltar");
			Scanner sc = new Scanner(System.in);
			entrada = sc.nextLine();

			option = menucontroller.validationRegexMenu(entrada, "[0-6]");
			switch (option) {
			case 0: {
				primaryMenu();
				break;
			}
			case 1: {
				menuDoSale();

				break;
			}
			case 2: {
				// saleRegister(); metodo para realizar venda
				break;
			}
			default:
				System.out.println("\nOp��o invalida. Tente Novamente. \n");
			}
		}

	}

	private void menuDoSale() {
		String sku;
		Product product;
		Integer quantidade = 0;
		Integer quantidadeestoque = 10;
		Map<String, Integer> products = new HashMap<>();
		Integer option;
		
		while (true) {
			while (true) {
				System.out.println("digite o sku: ");
				sku = scanner.nextLine();
				scanner.nextLine();
				if (metodoProvisorio(sku) == null) {
					System.out.println("produto não existe");
				} else {
					System.out.println("digite a quantidade:");
					quantidade = scanner.nextInt();
					if (quantidade < 1) {
						System.out.println("digite 1 ou mais");
						continue;
					} else if (quantidade > quantidadeestoque) {
						System.out.println("digite uma quantidade menor, em estoque só temos " + quantidadeestoque);
						continue;
					}
					break;
				}
				break;
			}
			products.put(sku, quantidade);
			
			System.out.println("Deseja inserir outro produto?\n 1 - sim\n2 - nao");
			option = scanner.nextInt();
			if(option == 1) {
				continue;
			}else if(option == 2) {
				break;
			}else {
				System.out.println("Opção invalida");
			}
			
		}
	
		Integer resposta;
		String cpf;
		Client client;
		//Boolean clientIsValid = true;
		while (true) {
			System.out.println("deseja colocar o cpf? 1-sim ou 2-não ?");
			resposta = scanner.nextInt();
			if (resposta == 1) {
				while (true) {
					System.out.println("digite o cpf: ");
					cpf = scanner.next();
					if (menucontroller.validarCpf(cpf)) {
						if(clientcontroller.clientIsRegistered(cpf)) {
							client = clientcontroller.findByCPF(cpf);
						}
						else{
							//registerClient(cpf);
						}
						break;
					}
					System.out.println("CPF invalido ou Cliente Cadastrado");
				}
				break;
			} else if (resposta == 2) {
				break;
			} else {
				System.out.println("digite uma resposta válida");
			}
		}
		Integer opcao;
		String dadosCartaoCredito;
		String dadosCartaoDebito;
		String numPix;
		PaymentMethod paymentmethod;
		
		while (true) {
			System.out.println(
					"Digite a forma de pagamento: 1- cart�o de cr�dito | 2 -cart�o de d�bito | 3- dinheiro| 4-pix");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				paymentmethod = PaymentMethod.CARTAODECREDITO;
				System.out.println("Digite o numero do Cartão");
				dadosCartaoCredito = scanner.nextLine();
				scanner.nextLine();
				if(!menucontroller.validationCard(dadosCartaoCredito)) {
					System.out.println("Cartao Invalido");
					continue;
				}
				break;
			case 2:
				paymentmethod = PaymentMethod.CARTAODEDEBITO;
				dadosCartaoDebito = scanner.nextLine();
				if(!menucontroller.validationCard(dadosCartaoDebito)) {
					System.out.println("Cartão Invalido");
					continue;
				}
				break;
			case 3:
				paymentmethod = PaymentMethod.DINHEIRO;
				break;
			case 4:
				paymentmethod = PaymentMethod.PIX;
				numPix = scanner.nextLine();
				//metodo para armazenar o pix
				break;
			default:
				System.out.println("op��o inv�lida");
				continue;
			}
			break;

		}
		// salecontroller.saleRegister(null, List.of(), null, paymentmethod)

	}

	private String metodoProvisorio(String sku) {
		return "isto � um produto";

	}

	private void menuProducts() {
		int option = -1;
		String entrada;

		while (option != 0) {
			System.out.println("1 - Cadastrar Produto" + "\n2 - Buscar Produto (ID)" + "\n3 - Buscar Produto (SKU)"
					+ "\n4 - Lista Produtos" + "\n5 - Atualizar Produtos" + "\n6 - Excluir Produto"
					+ "\n0 - Para voltar");

			Scanner sc = new Scanner(System.in);
			entrada = sc.nextLine();

			MenuController menuController = new MenuController();
			option = menuController.validationRegexMenu(entrada, "[0-6]");

			switch (option) {
			case 0: {
				primaryMenu();
				break;
			}
			case 1: {
				// cadastrarProduto(); metodo para cadastrar produto
				break;
			}
			case 2: {
				// buscarProdutoId(); metodo para buscar produto pelo ID
				break;
			}
			case 3: {
				// buscarProdutoSku(); metodo para buscar pelo SKU
				break;
			}
			case 4: {
				// listarProdutos(); metodo para listar produtos
				break;
			}
			case 5: {
				// atualizarProdutos(); metodo para atualizar produtos
				break;
			}
			case 6: {
				// excluirProdutos(); metodo para excluir produtos
				break;
			}
			default:
				System.out.println("\nOpção Invalida. Tente Novamente \n");
			}
		}

//	private void menuClients() {
//		
//		
//	}
//		
	}
}
