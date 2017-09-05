package my.toolkit.test.katataxe.services.report;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import my.toolkit.test.katataxe.domain.product.Product;
import my.toolkit.test.katataxe.services.report.ReportServices;

public class ReportServicesTest {
	private String sep = System.getProperty("line.separator");
	private ReportServices reportServices;

	@Before
	public void setUp() throws Exception {
		reportServices = ReportServices.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void afficheTotal() {
		// given
		String products = " : 0.00" + sep;
		String expected = products +
				"Montant des taxes : 0.00" + sep +
				"Total : 0.00";
		
		//and
		Product product = Product.builder().withPrixHT(0).withTaxe(0).build();

		// when
		String actual = reportServices.report(product);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void afficheTotalFormatFor0() {
		// given
		String products = " : 0.00" + sep;
		String expected = products +
				"Montant des taxes : 0.00" + sep +
				"Total : 0.00";
		Product product = Product.builder().withPrixHT(0).withTaxe(0).build();
		
		// when
		String actual = reportServices.report(product);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void afficheTotalFormatFor1() {
		// given
		String products = " : 1.00" + sep;
		String expected = products +
				"Montant des taxes : 1.00" + sep +
				"Total : 1.00";
		Product product = Product.builder().withPrixHT(1).withTaxe(1).build();
		
		// when
		String actual = reportServices.report(product);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void afficheTotalFor1Product() {
		// given
		String products = "1 CD musical : 16.49" + sep;
		String expected = products +
				"Montant des taxes : 0.00" + sep +
				"Total : 16.49";
		// and
		Product product = Product.builder().withName("1 CD musical").withPrixHT(16.49d).withTaxe(0).build();

		// when
		String actual = reportServices.report(product);

		// then
		assertThat(actual).isEqualTo(expected);
	}
}
