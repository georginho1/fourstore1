package br.com.foursys.fourcamp.fourstore.communication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.controller.ClientController;
import br.com.foursys.fourcamp.fourstore.controller.MenuController;
import br.com.foursys.fourcamp.fourstore.controller.ProductController;
import br.com.foursys.fourcamp.fourstore.controller.SaleController;
import br.com.foursys.fourcamp.fourstore.enums.PaymentMethod;
import br.com.foursys.fourcamp.fourstore.model.Client;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class MainMenu {
	private static Scanner scanner;
	private static ProductController productController;
	private static MenuController menuController;
	private static ClientController clientController;
	private static SaleController saleController;
	
	public MainMenu() {
		scanner = new Scanner(System.in);
		saleController = new SaleController();
		clientController = new ClientController();
		productController = new ProductController();
		menuController = new MenuController();
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
			entrada = scanner.nextLine();

			option = menuController.validationRegexMenu(entrada, "[0-2]");
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
				String result = saleController.saleConsultation();
				System.out.println(result);
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
		Integer quantidade = 0;
		Map<String, Integer> products = new HashMap<>();
		Integer option;
		
		while (true) {
			while (true) {
				System.out.println("digite o sku: ");
				sku = scanner.nextLine();
				scanner.nextLine();
				if (productController.getProductBySku(sku) == null) {
					System.out.println("produto nÃ£o existe");
				} else {
					System.out.println("digite a quantidade:");
					quantidade = scanner.nextInt();
					if (quantidade < 1) {
						System.out.println("digite 1 ou mais");
						continue;
					} else if (!productController.haveStock(sku, quantidade)) {
						System.out.println("Quantidade maior do que possuimos" );
						continue;
					}
					break;
				}
				break;
			}
			products.put(sku, quantidade);
			
			System.out.println("Deseja inserir outro produto?\n 1 - sim\n2 - nao");
			option = scanner.nextInt();
			if (option == 1) {
				continue;
			} else if (option == 2) {
				break;
			} else {
				System.out.println("OpÃ§Ã£o invalida");
			}
		}
	
		Integer resposta;
		String cpf;
		String nome;
		Client client;

		while (true) {
			System.out.println("deseja colocar o cpf? 1-sim ou 2-nÃ£o ?");
			resposta = scanner.nextInt();
			if (resposta == 1) {
				while (true) {
					System.out.println("digite o cpf: ");
					cpf = scanner.next();
					if (menuController.validarCpf(cpf)) {
						if(clientController.clientIsRegistered(cpf)) {
							client = clientController.findByCPF(cpf);
						}
						else{
							System.out.println("Digite o nome do cliente");
							nome = scanner.next();
							clientController.registerClient( nome,  cpf);
						}
						break;
					}
					System.out.println("CPF invalido ou Cliente Cadastrado");
				}
				break;
			} else if (resposta == 2) {
				break;
			} else {
				System.out.println("digite uma resposta vÃ¡lida");
			}
		}
		
		Integer opcao;
		String dadosCartaoCredito;
		String dadosCartaoDebito;
		String numPix;
		PaymentMethod paymentmethod;
		
		while (true) {
			System.out.println(
					"Digite a forma de pagamento: 1- cartï¿½o de crï¿½dito | 2 -cartï¿½o de dï¿½bito | 3- dinheiro| 4-pix");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				paymentmethod = PaymentMethod.CARTAODECREDITO;
				System.out.println("Digite o numero do CartÃ£o");
				dadosCartaoCredito = scanner.nextLine();
				scanner.nextLine();
				if(!menuController.validationCard(dadosCartaoCredito)) {
					System.out.println("Cartao Invalido");
					continue;
				}
				break;
			case 2:
				paymentmethod = PaymentMethod.CARTAODEDEBITO;
				dadosCartaoDebito = scanner.nextLine();
				if(!menuController.validationCard(dadosCartaoDebito)) {
					System.out.println("CartÃ£o Invalido");
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
				System.out.println("opção inválida");
				continue;
			}
			break;
		}
	}

	private void menuProducts() {
		int option = -1;
		String entrada;

		while (option != 0) {
			System.out.println("1 - Cadastrar Produto" + "\n2 - Buscar Produto por id" + "\n3 - Buscar Produto por sku"
					+ "\n4 - Lista Produtos" + "\n5 - Atualizar Produto por id" + "\n6 - Atualizar produto por sku"
					+ "\n7 - Excluir Produto pelo id" + "\n8 - Excluir Produto pelo sku" + "\n0 - Para voltar");

			entrada = scanner.next();

			option = menuController.validationRegexMenu(entrada, "[0-8]");

			switch (option) {
			case 0: {
				this.primaryMenu();
				break;
			}
			case 1: {
				this.cadProduct();
				break;
			}
			case 2: {
				this.getProductById();
				break;
			}
			case 3: {
				this.getProductBySku();
				break;
			}
			case 4: {
				String retorno = productController.listProducts();// metodo para listar produtos
				System.out.println(retorno);
				break;
			}
			case 5: {
				// updateProductById(); metodo para atualizar produtos, encontrando pelo id
				break;
			}
			case 6: {
				// updateProductBySku(); metodo para atualizar produtos, encontrando pelo sku
				break;
			}
			case 7: {
				this.deleteProductById();
				break;
			}
			case 8: {
				this.deleteProductBySku();
				break;
			}
			default:
				System.out.println("\nOpção Invalida. Tente Novamente \n");
			}
		}
	}
	
	public void cadProduct() {
		String sku;
		
		while (true) {
			System.out.println("Insira o sku do produto");
			sku = scanner.next();
			if(productController.productIsRegistered(sku)) {
				System.out.println("SKU já cadastrado. \n");
			} else if(!(productController.validateSku(sku))) {
				System.out.println("SKU inválido");
			} else {
				break;
			}
		}
		
		System.out.println("Insira a descrição do produto");
		scanner.nextLine();
		String description = scanner.nextLine();
		
		System.out.println("Insira a quantidade do produto");
		Integer quantity = scanner.nextInt();
		
		System.out.println("Insira o valor de compra do produto");
		Double purchasePrice = scanner.nextDouble();
		
		System.out.println("Insira o valor de venda do produto");
		Double salePrice = scanner.nextDouble();
		
		String retorno = productController.cadProduct(sku, description, quantity, purchasePrice, salePrice);
		System.out.println(retorno);

	}
	
	private void getProductById() {
		System.out.print("\nInsira o id do produto: ");
		String id = scanner.next();
		System.out.println(productController.getProductById(id) + "\n");
	}
	
	private void getProductBySku() {
		System.out.print("\nInsira o sku do produto: ");
		String sku = scanner.next();
		if(!(productController.validateSku(sku))) {
			System.out.println("SKU inválido");
		} else {
			System.out.println(productController.getProductBySku(sku) + "\n");
		}
		
	}
	
	private void deleteProductById() {
		System.out.print("\nInsira o id do produto: ");
		String id = scanner.next();
		System.out.println(productController.deleteProductById(id) + "\n");
	}
	
	private void deleteProductBySku() {
		System.out.print("\nInsira o sku do produto: ");
		String sku = scanner.next();
		if(!(productController.validateSku(sku))) {
			System.out.println("SKU inválido");
		}else {
			System.out.println(productController.deleteProductBySku(sku) + "\n");
		}
	}
//	private void menuClients() {
//		
//		
//	}
//		
}

