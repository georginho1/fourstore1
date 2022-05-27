package br.com.foursys.fourcamp.fourstore.communication;


import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.controller.ClientController;
import br.com.foursys.fourcamp.fourstore.controller.MenuController;
import br.com.foursys.fourcamp.fourstore.controller.ProductController;
import br.com.foursys.fourcamp.fourstore.controller.SaleController;
import br.com.foursys.fourcamp.fourstore.enums.PaymentMethod;


public class MainMenu {
	private Scanner scanner;
	private MenuController menucontroller;
	private SaleController salecontroller;
	private ClientController clientcontroller;
	private ProductController productcontroller;
	
	public MainMenu() {
		this.menucontroller = new MenuController();
		this.scanner = new Scanner(System.in);
		this.salecontroller = new SaleController();
		this.clientcontroller = new ClientController();
		this.productcontroller = new ProductController();
	}

	public void mainMenu() {
		primaryMenu();
	}

	private void primaryMenu() {

		Integer option = -1;
		String entrada;

		while (option != 0) {
			System.out.println("\n\n==========FOURSTORE=============||");
			System.out.println("1 - Produtos                    ||");
			System.out.println("2 - Vendas                      ||");
			System.out.println("0 - Sair do sistema             ||");
			System.out.print("Insira uma opção: ");
			entrada = scanner.next();
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
			default:
				System.out.println("\nOpcao Invalida. Tente Novamente. \n");
			}
		}
	}


	private void menuSales() {
		int option = -1;
		String entrada;

		while (option != 0) {
			System.out.println("1 - Realizar Venda" + "\n2 - Consultar o histórico de vendas" + "\n0 - Para voltar");
			entrada = scanner.next();

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
				String result = salecontroller.saleConsultation();
				System.out.println(result);
				break;
			}
			default:
				System.out.println("\nOpcao invalida. Tente Novamente. \n");
			}
		}

	}

	private void menuDoSale() {
		String sku;
		Integer qtt = 0;
		Integer option;
		salecontroller.clearCart();
		
		while(true) {
			while(true) {
				System.out.println("\ndigite o sku: ");
				sku = scanner.next();
				if (productcontroller.getProductBySku(sku) == null) {
					System.out.println("produto nao existe");
				} else {
					break;
				}
			}
			
			while(true) {
				qtt = 0;
				System.out.println("digite a quantidade:");
				qtt = scanner.nextInt();
				if (qtt < 1) {
					System.out.println("digite 1 ou mais");
				} else if (!productcontroller.haveStock(sku, qtt)) {
					System.out.println("Quantidade maior do que possuimos" );
					continue;
				} else {
					break;
				}
			}
			ProductController.decrementProduct(sku, qtt);
				
			
			System.out.println(salecontroller.addCart(sku, qtt)); 
			
			System.out.println("Deseja inserir outro produto?\n 1 - sim\n2 - nao");
			option = scanner.nextInt();
			
			if(option == 1) {
				continue;
			}else if(option == 2) {
				break;
			}else {
				System.out.println("Opcao invalida");
			}	
		}
		

		Integer resposta;
		String cpf = null;
		String nome;

		while (true) {
			System.out.println("deseja colocar o cpf? 1-sim ou 2-nao ?");
			resposta = scanner.nextInt();
			if (resposta == 1) {
				while (true) {
					System.out.println("digite o cpf: ");
					cpf = scanner.next();
					if (menucontroller.validarCpf(cpf)) {
						System.out.println("Digite o nome do cliente");
						nome = scanner.next();
						clientcontroller.registerClient(nome, cpf);
						break;
					} else {
						System.out.println("CPF invalido");
					}
				}
				break;
			} else if (resposta == 2) {
				break;
			} else {
				System.out.println("digite uma resposta valida");
			}
		}
		
		
		Integer opcao;
		String dadosCartaoCredito;
		String dadosCartaoDebito;
		String chavePix;
		PaymentMethod paymentmethod;
		
		while (true) {
			System.out.println(
					"Digite a forma de pagamento: \n1- cartao de credito \n2 -cartao de debito \n3- dinheiro \n4-pix");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				paymentmethod = PaymentMethod.CARTAODECREDITO;
				System.out.println("Digite o numero do Cartao");
				dadosCartaoCredito = scanner.next();
				scanner.nextLine();
				if(!menucontroller.validationCard(dadosCartaoCredito)) {
					System.out.println("Cartao Invalido");
					continue;
				}
				break;
			case 2:
				paymentmethod = PaymentMethod.CARTAODEDEBITO;
				dadosCartaoDebito = scanner.next();
				if(!menucontroller.validationCard(dadosCartaoDebito)) {
					System.out.println("Cartao Invalido");
					continue;
				}
				break;
			case 3:
				paymentmethod = PaymentMethod.DINHEIRO;
				break;
			case 4:
				paymentmethod = PaymentMethod.PIX;
				System.out.println("Digite e chave pix");
				chavePix = scanner.next();
				if(cpf == null) {
					clientcontroller.registerPix(chavePix);
				} else {
					clientcontroller.registerPix(chavePix, cpf);

				}
				break;
			default:
				System.out.println("opcao invalida");
				continue;
			}
			break;

		}
						
		if(cpf != null) {
			System.out.println(salecontroller.saleRegister(paymentmethod, cpf)); 
		} else {
			System.out.println(salecontroller.saleRegister(paymentmethod)); 
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

			option = menucontroller.validationRegexMenu(entrada, "[0-8]");

			switch (option) {
			case 0: {
				primaryMenu();
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
				String retorno = productcontroller.listProducts();// metodo para listar produtos
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
				System.out.println("\nOpcao Invalida. Tente Novamente \n");
			}
		}
	}
	
	public void cadProduct() {
		String sku;
		
		while (true) {
			System.out.println("Insira o sku do produto");
			sku = scanner.next();
			if(!productcontroller.productIsRegistered(sku)) {
				break;
			}else {
				System.out.println("SKU ja cadastrado. \n");
				mainMenu();
			}
		}
		
		System.out.println("Insira a descricao do produto");
		scanner.nextLine();
		String description = scanner.nextLine();
		
		System.out.println("Insira a quantidade do produto");
		Integer quantity = scanner.nextInt();
		
		System.out.println("Insira o valor de compra do produto");
		Double purchasePrice = scanner.nextDouble();
		
		System.out.println("Insira o valor de venda do produto");
		Double salePrice = scanner.nextDouble();
		
		String retorno = productcontroller.cadProduct(sku, description, quantity, purchasePrice, salePrice);
		System.out.println(retorno);
	}
	
	
	private void getProductById() {
		System.out.print("\nInsira o id do produto: ");
		String id = scanner.next();
		System.out.println(productcontroller.getProductById(id) + "\n");
	}
	
	private void getProductBySku() {
		System.out.print("\nInsira o sku do produto: ");
		String sku = scanner.next();
		System.out.println(productcontroller.getProductBySku(sku) + "\n");
	}
	
	private void deleteProductById() {
		System.out.print("\nInsira o id do produto: ");
		String id = scanner.next();
		System.out.println(productcontroller.deleteProductById(id) + "\n");
	}
	
	private void deleteProductBySku() {
		System.out.print("\nInsira o sku do produto: ");
		String sku = scanner.next();
		System.out.println(productcontroller.deleteProductBySku(sku) + "\n");
	}
	
	}

