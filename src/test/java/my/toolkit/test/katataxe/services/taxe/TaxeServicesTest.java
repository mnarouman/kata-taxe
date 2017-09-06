package my.toolkit.test.katataxe.services.taxe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		double actual = taxeProvider.round(input);
		
		//then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void arrondiWhen1_00Then1_00() {
		//given
		double input = 1.00;
		double expected = 1.00;
		
		//when
		double actual = taxeProvider.round(input);
		
		//then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void arrondiWhen1_01Then1_05() {
		//given
		double input = 1.01;
		double expected = 1.05;
		
		//when
		double actual = taxeProvider.round(input);
		
		//then
		assertThat(actual).isEqualTo(expected);
	}
}
