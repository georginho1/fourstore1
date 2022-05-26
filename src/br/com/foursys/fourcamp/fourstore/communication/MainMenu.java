package br.com.foursys.fourcamp.fourstore.communication;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.controller.MenuController;
import br.com.foursys.fourcamp.fourstore.controller.ProductController;
import br.com.foursys.fourcamp.fourstore.controller.SaleController;
import br.com.foursys.fourcamp.fourstore.enums.PaymentMethod;
import br.com.foursys.fourcamp.fourstore.model.Client;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class MainMenu {

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
				String retorno = productController.listProducts();// metodo para listar produtos
				System.out.println(retorno);
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