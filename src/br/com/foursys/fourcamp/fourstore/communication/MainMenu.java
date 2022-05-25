package br.com.foursys.fourcamp.fourstore.communication;

import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.controller.ProductController;

public class MainMenu {
	ProductController productC;
	
	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Menu principal");
			System.out.println("Selecione uma opção"
					+ "\n 1 - Cadastrar produtos"
					+ "\n 0 - sair \n");
			Integer opcao = sc.nextInt();
			switch (opcao) {
			case 1: {
				cadProduct();
				break;
			}
			default:
				System.err.print("selecione uma opção válida");
			}
		}		
	}
	
	
	public void cadProduct() {
		 //no pacote model, na classe product, os construtores não possuem o
		//parametro id, deve-se crialo?
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira o sku do produto");
		String sku = sc.next();
		
		System.out.println("Insira a descrição do produto");
		sc.next();
		String description = sc.nextLine();
		
		System.out.println("Insira o tipo do produto");
		String type = sc.next();
		
		System.out.println("Insira o tamanho do produto");
		String size = sc.next();
		
		System.out.println("Insira a cor do produto");
		String color = sc.next();
		
		System.out.println("Insira a categoria do produto");
		String category = sc.next();
		
		System.out.println("Insira a estação do produto");
		String season = sc.next();
		
		System.out.println("Insira a quantidade do produto");
		Integer quantity = sc.nextInt();
		
		System.out.println("Insira o valor de compra do produto");
		Double purchasePrice = sc.nextDouble();
		
		System.out.println("Insira o valor de venda do produto");
		Double salePrice = sc.nextDouble();
		
		productC = new ProductController();
		String retorno = productC.cadProduct(sku, description, type, size, color, category, season, quantity, purchasePrice, salePrice);
		System.out.println(retorno);

	}
	
	
}
