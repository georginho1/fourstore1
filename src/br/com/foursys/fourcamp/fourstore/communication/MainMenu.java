package br.com.foursys.fourcamp.fourstore.communication;

import java.util.Scanner;
import br.com.foursys.fourcamp.fourstore.controller.MenuController;
import br.com.foursys.fourcamp.fourstore.controller.ProductController;
import br.com.foursys.fourcamp.fourstore.controller.SaleController;


public class MainMenu {
	private static Scanner scanner;
	private static ProductController productController;
	private static MenuController menuController;
	
	public MainMenu() {
		scanner = new Scanner(System.in);
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
		SaleController saleController = new SaleController();
		int option = -1;
		String entrada;

		while (option != 0) {
			System.out.println("1 - Realizar Venda" + "\n2 - Consultar uma venda" + "\n0 - Para voltar");
			entrada = scanner.nextLine();

			MenuController menuController = new MenuController();
			option = menuController.validationRegexMenu(entrada, "[0-6]");
			switch (option) {
			case 0: {
				primaryMenu();
				break;
			}
			case 1: {	
				//Se o cliente deseja informar os seus dados, chamar:
				//String resultado = saleController.saleRegister(Cliente, listaTeste, saleController.amountValeu(listaTeste), metodoPagamentoTeste);
				//se não, chamar
				//String resultado = saleController.saleRegister(listaTeste, saleController.amountValeu(listaTeste), metodoPagamentoTeste);

				//System.out.println(resultado);
				
				break;
			}
			case 2: {
				
				System.out.println(saleController.saleConsultation());
				break;
			}
			default:
				System.out.println("\nOpção invalida. Tente Novamente. \n");
			}
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
			if(!productController.productIsRegistered(sku)) {
				break;
			}else {
				System.out.println("SKU já cadastrado. \n");
				mainMenu();
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
		System.out.println(productController.getProductBySku(sku) + "\n");
	}
	
	private void deleteProductById() {
		System.out.print("\nInsira o id do produto: ");
		String id = scanner.next();
		System.out.println(productController.deleteProductById(id) + "\n");
	}
	
	private void deleteProductBySku() {
		System.out.print("\nInsira o sku do produto: ");
		String id = scanner.next();
		System.out.println(productController.deleteProductBySku(id) + "\n");
	}
//	private void menuClients() {
//		
//		
//	}
//		
}

