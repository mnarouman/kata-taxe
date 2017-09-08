package my.toolkit.test.katataxe;

import java.util.ArrayList;
import java.util.List;

import my.toolkit.test.katataxe.domain.command.Command;
import my.toolkit.test.katataxe.domain.product.Livre;
import my.toolkit.test.katataxe.domain.product.Medicament;
import my.toolkit.test.katataxe.domain.product.Nourriture;
import my.toolkit.test.katataxe.domain.product.factory.AbstractProductFactory;
import my.toolkit.test.katataxe.domain.product.factory.ProductConfig;
import my.toolkit.test.katataxe.domain.product.factory.ProductFactory;
import my.toolkit.test.katataxe.services.report.ReportServices;
import my.toolkit.test.katataxe.services.taxe.Taxable;

public class Main {
	private static AbstractProductFactory productFactory = ProductFactory.builder().build();
	private static ReportServices reportServices = ReportServices.getInstance();
	private static final String SEP = System.getProperty("line.separator");
	
	public static void main(String[] args) {
		System.out.println("#### Output 1"+SEP);
		System.out.println(afficheOutput1());
		System.out.println(SEP);
		
		System.out.println("#### Output 2"+SEP);
		System.out.println(afficheOutput2());
		System.out.println(SEP);
		
		System.out.println("#### Output 3"+SEP);
		System.out.println(afficheOutput3());
	}

	// C'est l'output 1
	private static String afficheOutput1() {
		List<Taxable> products = new ArrayList<>();
		ProductConfig productConfig = ProductConfig.builder().productType(Livre.class).productName("1 livre").prixHT(12.49d).build();
		Taxable product1 = productFactory.factoryMethod(productConfig);

		productConfig = ProductConfig.builder().productName("1 CD musical").prixHT(14.99d).build();
		Taxable product2 = productFactory.factoryMethod(productConfig);
		
		productConfig = ProductConfig.builder().productType(Nourriture.class).productName("1 barre de chocolat").prixHT(0.85d).build();
		Taxable product3 = productFactory.factoryMethod(productConfig);

		products.add(product1);
		products.add(product2);
		products.add(product3);

		Command command = Command.builder().id(1).products(products).build();

		return reportServices.report(command);
	}

	// C'est l'output 2
	private static String afficheOutput2() {
		List<Taxable> products = new ArrayList<>();
		ProductConfig productConfig = ProductConfig.builder().productType(Nourriture.class).productName("1 boîte de chocolats importée").prixHT(10.00d).imported(true).build();
		Taxable product1 = productFactory.factoryMethod(productConfig);

		productConfig = ProductConfig.builder().productName("1 flacon de parfum importé").prixHT(47.50d).imported(true).build();
		Taxable product2 = productFactory.factoryMethod(productConfig);
		
		products.add(product1);
		products.add(product2);

		Command command = Command.builder().id(1).products(products).build();

		return reportServices.report(command);
	}

	// C'est l'output 3
	private static String afficheOutput3() {
		List<Taxable> products = new ArrayList<>();
		
		ProductConfig productConfig = ProductConfig.builder().productName("1 flacon de parfum importé").prixHT(27.99d).imported(true).build();
		Taxable product1 = productFactory.factoryMethod(productConfig);

		productConfig = ProductConfig.builder().productName("1 flacon de parfum").prixHT(18.99d).build();
		Taxable product2 = productFactory.factoryMethod(productConfig);

		productConfig = ProductConfig.builder().productName("1 boîte de pilules contre la migraine").productType(Medicament.class).prixHT(9.75d).build();
		Taxable product3 = productFactory.factoryMethod(productConfig);
		
		productConfig = ProductConfig.builder().productName("1 boîte de chocolats importés").productType(Nourriture.class).prixHT(11.25d).imported(true).build();
		Taxable product4 = productFactory.factoryMethod(productConfig);

		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);

		Command command = Command.builder().id(1).products(products).build();

		return reportServices.report(command);
	}
}
