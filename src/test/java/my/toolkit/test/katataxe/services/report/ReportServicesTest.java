package my.toolkit.test.katataxe.services.report;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import my.toolkit.test.katataxe.domain.command.Command;
import my.toolkit.test.katataxe.domain.product.Product;

public class ReportServicesTest {
	private String sep = System.getProperty("line.separator");
	private ReportServices reportServices;
	private List<Product> products;

	@Before
	public void setUp() throws Exception {
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
		Product product = Product.builder().withPrixHT(0).withTaxe(0).build();
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
		Product product = Product.builder().withPrixHT(0).withTaxe(0).build();
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
		String sProducts = " : 1.00" + sep;
		String expected = sProducts +
				"Montant des taxes : 1.00" + sep +
				"Total : 1.00";
		Product product = Product.builder().withPrixHT(1).withTaxe(1).build();
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
		String sProducts = "1 CD musical : 16.49" + sep;
		String expected = sProducts +
				"Montant des taxes : 0.00" + sep +
				"Total : 16.49";
		// and
		Product product = Product.builder().withName("1 CD musical").withPrixHT(16.49d).withTaxe(0).build();
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
		String sProducts = "1 CD musical : 16.49" + sep +
				"1 flacon de parfum importé : 54.65";
		String expected = sProducts + sep +
				"Montant des taxes : 0.00" + sep +
				"Total : 71.14";
		// and
		Product product1 = Product.builder().withName("1 CD musical").withPrixHT(16.49d).withTaxe(0).build();
		Product product2 = Product.builder().withName("1 flacon de parfum importé").withPrixHT(54.65d).withTaxe(0).build();

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
		String sProducts = "1 CD musical : 16.49" + sep;
		String expected = sProducts +
				"Montant des taxes : 1.65" + sep +
				"Total : 18,14";
		// and
		Product product = Product.builder().withName("1 CD musical")
										   .withPrixHT(16.49d)
										   .withTaxe(10)
										   .build();
		products.add(product);
		Command command = Command.builder().withId(1).withProducts(products).build();

		// when
		String actual = reportServices.report(command);

		// then
		assertThat(actual).isEqualTo(expected);
	}

}
