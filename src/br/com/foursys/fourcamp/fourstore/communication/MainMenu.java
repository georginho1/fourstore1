package br.com.foursys.fourcamp.fourstore.communication;

import java.util.ArrayList;
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
			System.out.println("1 - Produtos                    ||");
			System.out.println("2 - Vendas                      ||");
//			System.out.println("3 - Clientes                    ||");
			System.out.println("0 - Sair do sistema             ||");
			System.out.print("Insira uma opção: ");
			option = scanner.nextInt();
			System.out.println("----------------------------------\n");


			switch(option) {
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
					System.out.println("\nOpção invalida. Tente novamente.\n");
			}
		}
	}

	private void menuSales() {
		SaleController saleController = new SaleController();
		int option = -1;
		
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
					
					//TESTE
//					Client clienteTeste = new Client("João", "12312312312", "chavePix");
//					
//					Product teste1 = new Product("14331160909251", "Camiseta do Batman", 48, 48.50, 92.80);
//					Product teste2 = new Product("15342230609352", "Camiseta do Aquamen", 95, 38.50, 62.80);
//					Product teste3 = new Product("16333330609454", "Camiseta do Flesh", 27, 25.50, 42.80);	
//					
//					ArrayList<Product> listaTeste = new ArrayList<Product>();
//					
//					listaTeste.add(teste1);
//					listaTeste.add(teste2);
//					listaTeste.add(teste3);
					
//					PaymentMethod metodoPagamentoTeste = null;
//					metodoPagamentoTeste = metodoPagamentoTeste.PIX;

					//FIM DO TESTE
					String resultado = saleController.saleRegister(null, null, null, null);
					System.out.println(resultado);
					break;
				}
				case 2:{
					// saleConsultation(); metodo para consultar venda
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
					System.out.println("\nOpção invalida. Tente Novamente \n");
			}
			
		}
	}

//	private void menuClients() {
//		
//		
//	}
//		
}