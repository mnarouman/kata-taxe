package my.toolkit.test.katataxe.services.facture;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import my.toolkit.test.katataxe.domain.product.Product;

public class FactureServicesTest {

	private List<Product> products;

	@Before
	public void setUp() throws Exception {
		products = new ArrayList<>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void appliqueTaxe10Perc() {
		FactureServices factureServices = FactureServices.getUniqueInstance();
		//given
		Product product = Product.builder().withName("1 CD musical")
										   .withPrixHT(16.49d)
										   .withTaxe(10)
										   .build();
		
		double expectedPrixTTC = 18.14;
		double expectedTaxe = 1.65;
		
		
		//when
		factureServices.taxe(product);
		
		//then
		assertThat(product.getPrixTTC()).isEqualTo(expectedPrixTTC);
		assertThat(product.getTaxe()).isEqualTo(expectedTaxe);
		
		
	}

}
