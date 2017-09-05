package my.toolkit.test.katataxe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReportServicesTest {
	private String sep = System.getProperty("line.separator");
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void afficheTotal() {
		//given
		String expected = "Montant des taxes : 0.00"+sep+
						   "Total : 00.00"; 
		
		//when
		String actual = reportServices.report();
		
		//then
		assertThat(actual).isEqualTo(expected);
	}

}
