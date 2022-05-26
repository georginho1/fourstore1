package br.com.foursys.fourcamp.fourstore.communication;

import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.controller.MenuController;
import br.com.foursys.fourcamp.fourstore.controller.ProductController;
import br.com.foursys.fourcamp.fourstore.controller.SaleController;

public class MainMenu {
	
	private Scanner scanner;
	private ProductController productController;
	
	public MainMenu() {
		this.scanner = new Scanner(System.in);
		this.productController = new ProductController();
	}

	public void mainMenu() {

		primaryMenu();

	}

	private void primaryMenu() {
		Scanner scanner = new Scanner(System.in);
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
		SaleController saleController = new SaleController();
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
		ProductController productController = new ProductController();

		while (option != 0) {
			System.out.println("1 - Cadastrar Produto" + "\n2 - Buscar Produto por id" + "\n3 - Buscar Produto por sku"
					+ "\n4 - Lista Produtos" + "\n5 - Atualizar Produto por id" + "\n6 - Atualizar produto por sku"
					+ "\n7 - Excluir Produto pelo id" + "\n8 - Excluir Produto pelo sku" + "\n0 - Para voltar");

			Scanner sc = new Scanner(System.in);
			entrada = sc.nextLine();

			MenuController menuController = new MenuController();
			option = menuController.validationRegexMenu(entrada, "[0-8]");

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
	
	private void getProductById() {
		System.out.print("\nInsira o id do produto: ");
		String id = scanner.next();
		System.out.println(this.productController.getProductById(id) + "\n");
	}
	
	private void getProductBySku() {
		System.out.print("\nInsira o sku do produto: ");
		String sku = scanner.next();
		System.out.println(this.productController.getProductBySku(sku) + "\n");
	}
	
	private void deleteProductById() {
		System.out.print("\nInsira o id do produto: ");
		String id = scanner.next();
		System.out.println(this.productController.deleteProductById(id) + "\n");
	}
	
	private void deleteProductBySku() {
		System.out.print("\nInsira o sku do produto: ");
		String id = scanner.next();
		System.out.println(this.productController.deleteProductBySku(id) + "\n");
	}
//	private void menuClients() {
//		
//		
//	}
//		
}

