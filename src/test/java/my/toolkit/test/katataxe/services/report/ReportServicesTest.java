package my.toolkit.test.katataxe.services.report;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		String expected = "Montant des taxes : 0.00" + sep +
				"Total : 0.00";

		// when
		String actual = reportServices.report(0, 0);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void afficheTotalFormatFor0() {
		// given
		String expected = "Montant des taxes : 0.00" + sep +
				"Total : 0.00";
		double taxes = 0;
		double total = 0;

		// when
		String actual = reportServices.report(taxes, total);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void afficheTotalFormatFor1() {
		// given
		String expected = "Montant des taxes : 1.00" + sep +
				"Total : 1.00";
		double taxes = 1;
		double total = 1;

		// when
		String actual = reportServices.report(taxes, total);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void afficheTotalFor1Product() {
		// given
		String expected = "1 CD musical : 16.49" + sep +
				"Montant des taxes : 0.00" + sep +
				"Total : 0.00";
		// and
		Product product = new Product();
		product.setPrixHT(16.49d);

		// when
		String actual = reportServices.report(product);

		// then
		assertThat(actual).isEqualTo(expected);
	}
}
