package br.com.foursys.fourcamp.fourstore.communication;

import java.util.List;
import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.controller.MenuController;
import br.com.foursys.fourcamp.fourstore.controller.SaleController;
import br.com.foursys.fourcamp.fourstore.enums.PaymentMethod;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class MainMenu {
	private Scanner scanner;
	private MenuController menucontroller;
	private SaleController salecontroller;

	public MainMenu() {
		this.menucontroller = new MenuController();
		this.scanner = new Scanner(System.in);
		this.salecontroller=new SaleController();
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
			System.out.print("Insira uma opção: ");
			entrada = scanner.nextLine();
			System.out.println("----------------------------------\n");

			MenuController menuController = new MenuController();
			option = menuController.validationRegexMenu(entrada, "[0-6]");

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

			MenuController menuController = new MenuController();
			option = menuController.validationRegexMenu(entrada, "[0-6]");
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
				System.out.println("\nOpção invalida. Tente Novamente. \n");
			}
		}

	}

	private void menuDoSale() {
		String sku;
		Product product;

		while (true) {
			System.out.println("digite o sku: ");
			sku = scanner.nextLine();
			if (metodoProvisorio(sku) == null) {
				System.out.println("produto não existe");
			} else {
				//adicionar produto
			}
				break;
		}

		Integer quantidade;
		Integer quantidadeestoque = 10;// excluir isto
		while (true) {
			System.out.println("digite a quantidade:");
			quantidade = scanner.nextInt();
			if (quantidade < 1) {
				System.out.println("digite 1 ou mais");
				continue;

			} else if (quantidade > quantidadeestoque) {
				System.out.println("digite uma quantidade menor, em estoque só tem " + quantidadeestoque);
				continue;
			}
			break;

		}
		String resposta;
		String cpf;
		while (true) {
			System.out.println("deseja colocar o cpf? sim ou não ?");
			resposta = scanner.next();
			if (resposta == "sim") {
				while (true) {
					System.out.println("digite o cpf: ");
					cpf = scanner.next();
					if (menucontroller.validarCpf(cpf)) {
						//verificar se o cliente existe no client data, se não existir o client deve ser cadastrado
						break;
					}
						
					

					else {
						System.out.println("digite um cpf válido");
					}

				}
				break;
			} else if (resposta == "não") {
				break;
			} else {
				System.out.println("digite uma resposta válida");
			}
		}
		Integer opcao;
		PaymentMethod paymentmethod;
		while (true) {
			System.out.println("digite a forma de pagamento: 1- cartão de crédito | 2 -cartão de débito | 3- dinheiro| 4-pix");
			opcao=scanner.nextInt();
			switch(opcao) {
			case 1:
				paymentmethod=PaymentMethod.CARTAODECREDITO;
				//pedir dados 
				break;
			case 2:
				paymentmethod=PaymentMethod.CARTAODEDEBITO;
				//pedir dados 
				break;
			case 3:
				paymentmethod=PaymentMethod.DINHEIRO;				
				break;
			case 4:
				paymentmethod=PaymentMethod.PIX;
				//pedir dados 
				break;
			default:
				System.out.println("opção inválida");
				continue;
			}
			break;
			
		}
		//salecontroller.saleRegister(null, List.of(), null, paymentmethod)

	}

	private String metodoProvisorio(String sku) {
		return "isto é um produto";

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
				System.out.println("\nOpÃ§Ã£o Invalida. Tente Novamente \n");
			}
		}

//	private void menuClients() {
//		
//		
//	}
//		
	}
}
