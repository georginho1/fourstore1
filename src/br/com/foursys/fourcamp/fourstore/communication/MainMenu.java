package br.com.foursys.fourcamp.fourstore.communication;

import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.controller.SaleController;

public class MainMenu {

	public void mainMenu() {

		primaryMenu();

	}
	private void primaryMenu() {
		Scanner scanner = new Scanner(System.in);
		int option = -1;
		
		while(option != 0) {
			System.out.println("==========FOURSTORE=============||");
			System.out.println("1 - Clientes                    ||");
			System.out.println("2 - Produtos                    ||");
			System.out.println("3 - Vendas                      ||");
			System.out.println("0 - Sair do sistema             ||");
			System.out.print("Insira uma opção: ");
			option = scanner.nextInt();
			System.out.println("----------------------------------\n");


			switch(option) {
				case 0:
					System.out.println("\nSistema encerrado");
					break;
				case 1:
					this.menuClients();
					break;
				case 2:
					this.menuProducts();
					break;
				case 3:
					this.menuSales();
					break;
				default:
					System.out.println("\nOpção inválida. Tente novamente.\n");
			}
		}
	}

	private void menuSales() {
		int option = -1;
		
		SaleController saleController = new SaleController();
		
		while(option != 0) {
			System.out.println("1 - Realizar Venda"
					+ "\n2 - Consultar uma venda"
					+ "\n0 - Para voltar");
			Scanner sc = new Scanner(System.in);
			option = sc.nextInt();
			switch(option) {
			case 0:{
				primaryMenu();
				break;
			}
			case 1:{
				// => Precisa dos dados da venda.
				// saleRegister(); metodo para consultar venda
				saleController.saleRegister(null);
				break;
			}
			case 2:{ 
				// saleConsultation(); metodo para consultar venda
				System.out.println(saleController.saleConsultation());
				break;
			}
			default:
				System.out.println("\nOpcão Inválida. Tente Novamente. \n");
		}
		}
		
	}

	private void menuProducts() {
		int option = -1;
		
		while(option != 0) {
		System.out.println("1 - Cadastrar Produto"
				+ "\n2 - Buscar Produto (ID)"
				+ "\n3 - Buscar Produto (SKU)"
				+ "\n4 - Lista Produtos"
				+ "\n5 - Atualizar Produtos"
				+ "\n6 - Excluir Produto"
				+ "\n0 - Para voltar");
		
		Scanner sc = new Scanner(System.in);
		option = sc.nextInt();
		
		switch(option) {
		case 0:{
			primaryMenu();
			break;
		}
		case 1:{
			//cadastrarProduto(); metodo para cadastrar produto
			break;
		}
		case 2:{
			//buscarProdutoId(); metodo para buscar produto pelo ID
			break;
		}
		case 3:{
			//buscarProdutoSku(); metodo para buscar pelo SKU
			break;
		}
		case 4:{
			//listarProdutos(); metodo para listar produtos
			break;
		}
		case 5:{
			//atualizarProdutos(); metodo para atualizar produtos
			break;
		}
		case 6:{
			//excluirProdutos(); metodo para excluir produtos
			break;
		}
		default:
			System.out.println("\nOpção Invalida. Tente Novamente \n");
		}
		
	}
	}

	private void menuClients() {
		
		
	}
		
	}

