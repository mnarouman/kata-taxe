package my.toolkit.test.katataxe.services.report;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import my.toolkit.test.katataxe.domain.command.Command;
import my.toolkit.test.katataxe.domain.product.Livre;
import my.toolkit.test.katataxe.domain.product.Nourriture;
import my.toolkit.test.katataxe.domain.product.factory.AbstractProductFactory;
import my.toolkit.test.katataxe.domain.product.factory.IProduct;
import my.toolkit.test.katataxe.domain.product.factory.ProductConfig;
import my.toolkit.test.katataxe.domain.product.factory.ProductFactory;

public class ReportServicesTest {
	private String sep = System.getProperty("line.separator");
	private ReportServices reportServices;
	private List<IProduct> products;
	
	private AbstractProductFactory productFactory;

	@Before
	public void setUp() throws Exception {
		productFactory = ProductFactory.builder().build();
		reportServices = ReportServices.getInstance();
		products = new ArrayList<>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void afficheTotal() {
		// given
		String sProducts = " : 0.00" + sep;
		String expected = sProducts +
				"Montant des taxes : 0.00" + sep +
				"Total : 0.00";

		// and
		ProductConfig productConfig = ProductConfig.builder().withProductName("").withPrixHT(0).build();
		IProduct product = productFactory.factoryMethod(productConfig);
		products.add(product);
		Command command = Command.builder().withId(1).withProducts(products).build();

		// when
		String actual = reportServices.report(command);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void afficheTotalFormatFor0() {
		// given
		String sProducts = " : 0.00" + sep;
		String expected = sProducts +
				"Montant des taxes : 0.00" + sep +
				"Total : 0.00";
		
		ProductConfig productConfig = ProductConfig.builder().withProductName("").withPrixHT(0).build();
		IProduct product = productFactory.factoryMethod(productConfig);

		products.add(product);
		Command command = Command.builder().withId(1).withProducts(products).build();

		// when
		String actual = reportServices.report(command);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void afficheTotalFormatFor1() {
		// given
		String sProducts = " : 1.10" + sep;
		String expected = sProducts +
				"Montant des taxes : 0.10" + sep +
				"Total : 1.10";
		// and
		ProductConfig productConfig = ProductConfig.builder().withProductName("").withPrixHT(1).build();
		IProduct product = productFactory.factoryMethod(productConfig);

		products.add(product);
		Command command = Command.builder().withId(1).withProducts(products).build();

		// when
		String actual = reportServices.report(command);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void afficheTotalFor1Product() {
		// given
		String sProducts = "1 CD musical : 18.14" + sep;
		String expected = sProducts +
				"Montant des taxes : 1.65" + sep +
				"Total : 18.14";
		// and
		ProductConfig productConfig = ProductConfig.builder().withProductName("1 CD musical").withPrixHT(16.49d).build();
		IProduct product = productFactory.factoryMethod(productConfig);

		products.add(product);
		Command command = Command.builder().withId(1).withProducts(products).build();

		// when
		String actual = reportServices.report(command);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void afficheTotalFor2Products() {
		// given
		String sProducts = "1 CD musical : 18.14" + sep +
				"1 flacon de parfum : 20.89";
		String expected = sProducts + sep +
				"Montant des taxes : 3.55" + sep +
				"Total : 39.03";
		// and
		ProductConfig productConfig = ProductConfig.builder().withProductName("1 CD musical").withPrixHT(16.49d).build();
		IProduct product1 = productFactory.factoryMethod(productConfig);

		productConfig = ProductConfig.builder().withProductName("1 flacon de parfum").withPrixHT(18.99d).build();
		IProduct product2 = productFactory.factoryMethod(productConfig);

		products.add(product1);
		products.add(product2);

		Command command = Command.builder().withId(1).withProducts(products).build();

		// when
		String actual = reportServices.report(command);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void afficheTotalFor1ProductTaxe() {
		// given
		String sProducts = "1 CD musical : 18.14" + sep;
		String expected = sProducts +
				"Montant des taxes : 1.65" + sep +
				"Total : 18.14";
		// and
		ProductConfig productConfig = ProductConfig.builder().withProductName("1 CD musical").withPrixHT(16.49d).build();
		IProduct product = productFactory.factoryMethod(productConfig);

		products.add(product);
		Command command = Command.builder().withId(1).withProducts(products).build();

		// when
		String actual = reportServices.report(command);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	// C'est l'output 1
	@Test
	public void afficheTotalFor2ProductsWithExempted() {
		// given
		String sProducts = "1 livre : 12.49" + sep +
				"1 CD musical : 16.49"+sep+
				"1 barre de chocolat : 0.85";
		String expected = sProducts + sep +
				"Montant des taxes : 1.50" + sep +
				"Total : 29.83";
		// and
		ProductConfig productConfig = ProductConfig.builder().withClazz(Livre.class).withProductName("1 livre").withPrixHT(12.49d).build();
		IProduct product1 = productFactory.factoryMethod(productConfig);

		productConfig = ProductConfig.builder().withProductName("1 CD musical").withPrixHT(14.99d).build();
		IProduct product2 = productFactory.factoryMethod(productConfig);
		
		productConfig = ProductConfig.builder().withClazz(Nourriture.class).withProductName("1 barre de chocolat").withPrixHT(0.85d).build();
		IProduct product3 = productFactory.factoryMethod(productConfig);

		products.add(product1);
		products.add(product2);
		products.add(product3);

		Command command = Command.builder().withId(1).withProducts(products).build();

		// when
		String actual = reportServices.report(command);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	// C'est l'output 2
	@Test
	public void afficheTotalFor2ProductsWithImported() {
		// given
		String sProducts = "1 boîte de chocolats importée : 10.50" + sep +
				"1 flacon de parfum importé : 54.65";
		String expected = sProducts + sep +
				"Montant des taxes : 7.65" + sep +
				"Total : 65.15";
		// and
		ProductConfig productConfig = ProductConfig.builder().withClazz(Nourriture.class).withProductName("1 boîte de chocolats importée").withPrixHT(10.00d).withImported(true).build();
		IProduct product1 = productFactory.factoryMethod(productConfig);

		productConfig = ProductConfig.builder().withProductName("1 flacon de parfum importé").withPrixHT(47.50d).withImported(true).build();
		IProduct product2 = productFactory.factoryMethod(productConfig);
		
		products.add(product1);
		products.add(product2);

		Command command = Command.builder().withId(1).withProducts(products).build();

		// when
		String actual = reportServices.report(command);

		// then
		assertThat(actual).isEqualTo(expected);
	}
}
