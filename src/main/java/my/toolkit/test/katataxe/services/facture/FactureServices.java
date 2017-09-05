/**
 * 
 */
package my.toolkit.test.katataxe.services.facture;

import java.util.List;

import my.toolkit.test.katataxe.domain.command.Command;
import my.toolkit.test.katataxe.domain.facture.Facture;
import my.toolkit.test.katataxe.domain.product.Product;

/**
 * PatternBox: "Singleton" implementation.
 * <ul>
 *   <li>defines an Instance operation that lets clients access its unique instance. Instance is a class operation</li>
 *   <li>may be responsible for creating its own unique instance.</li>
 * </ul>
 * 
 * @author Dirk Ehms, <a href="http://www.patternbox.com">www.patternbox.com</a>
 * @author mnarouman
 */
public class FactureServices {

	/** unique instance */
	private static final FactureServices sInstance = new FactureServices();

	/** 
	 * Private constuctor
	 */
	private FactureServices() {
		super();
	}

	/** 
	 * Get the unique instance of this class.
	 */
	public static synchronized FactureServices getUniqueInstance() {

		return sInstance;

	}

	public Facture createFacture(Command command) {
		List<Product> products = command.getProducts();
		double totalHT = 0;
		double totalTaxe = 0;

		for (Product product : products) {

			double prixHT = product.getPrixHT();
			totalHT += prixHT;

			double productTaxe = product.getTaxe();
			totalTaxe += productTaxe;
		}

		Facture facture = Facture.builder().withId(command.getId()).withPrixHT(totalHT).withTotalTaxes(totalTaxe).withCommand(command).build();

		return facture;
	}

}
