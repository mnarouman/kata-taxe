package my.toolkit.test.katataxe.services.taxe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import my.toolkit.test.katataxe.domain.product.DefaultProduct;

public class TaxeServicesTest {
	private TaxeProvider taxeProvider ;
	
	@Before
	public void setUp() throws Exception {
		taxeProvider = TaxeProvider.getUniqueInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void arrondiWhen0_99Then1_00() {
		//given
		double input = 0.99;
		double expected = 1.00;
		
		//when
		double actual = taxeProvider.roundTaxe(input);
		
		//then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void arrondiWhen1_00Then1_00() {
		//given
		double input = 1.00;
		double expected = 1.00;
		
		//when
		double actual = taxeProvider.roundTaxe(input);
		
		//then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void arrondiWhen1_01Then1_05() {
		//given
		double input = 1.01;
		double expected = 1.05;
		
		//when
		double actual = taxeProvider.roundTaxe(input);
		
		//then
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	public void arrondiWhen1_02Then1_05() {
		//given
		double input = 1.02;
		double expected = 1.05;
		
		//when
		double actual = taxeProvider.roundTaxe(input);
		
		//then
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	public void appliqueTaxe10Perc() {
		TaxeServices taxeServices = TaxeServices.getUniqueInstance();
		//given
		Taxable product = DefaultProduct.builder().withName("1 CD musical")
										   .withPrixHT(16.49d)
										   .build();
		
		double expectedPrixTTC = 18.14;
		double expectedTaxe = 1.65;
		
		
		//when
		Taxable taxedProduct = taxeServices.taxe(product);
		
		//then
		assertThat(taxedProduct.getPrixTTC()).isEqualTo(expectedPrixTTC);
		assertThat(taxedProduct.getTaxe()).isEqualTo(expectedTaxe);
	}
}
