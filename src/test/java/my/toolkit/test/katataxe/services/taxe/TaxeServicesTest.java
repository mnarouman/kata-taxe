package my.toolkit.test.katataxe.services.taxe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import my.toolkit.test.katataxe.domain.product.Product;

public class TaxeServicesTest {

	@Before
	public void setUp() throws Exception {
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
		double actual = taxeProvider.round(input);
		
		//then
		assertThat(actual).isEqualTo(expected);
	}

}
