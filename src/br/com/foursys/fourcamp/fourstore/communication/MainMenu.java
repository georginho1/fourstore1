package br.com.foursys.fourcamp.fourstore.communication;

import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.controller.ProductController;

public class MainMenu {
	
	ProductController productC = new ProductController();
	
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
		String sku;
		
		while (true) {
			System.out.println("Insira o sku do produto");
			sku = sc.next();
			if(!productC.productIsRegistered(sku)) {
				System.out.println("if do menu");
				break;
			}else {
				System.out.println("SKU já cadastrado");
			}
		}
		
		System.out.println("Insira a descrição do produto");
		sc.nextLine();
		String description = sc.nextLine();
		
		System.out.println("Insira a quantidade do produto");
		Integer quantity = sc.nextInt();
		
		System.out.println("Insira o valor de compra do produto");
		Double purchasePrice = sc.nextDouble();
		
		System.out.println("Insira o valor de venda do produto");
		Double salePrice = sc.nextDouble();
		
		String retorno = productC.cadProduct(sku, description, quantity, purchasePrice, salePrice);
		System.out.println(retorno);

	}
	
	
}
