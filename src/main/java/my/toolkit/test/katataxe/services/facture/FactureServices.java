/**
 * 
 */
package my.toolkit.test.katataxe.services.facture;

import java.util.ArrayList;
import java.util.List;

import my.toolkit.test.katataxe.domain.command.Command;
import my.toolkit.test.katataxe.domain.facture.Facture;
import my.toolkit.test.katataxe.services.taxe.Taxable;
import my.toolkit.test.katataxe.services.taxe.TaxeServices;

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
	private TaxeServices taxeServices = TaxeServices.getUniqueInstance();

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
		List<Taxable> products = command.getProducts();
		List<Taxable> taxedProducts = new ArrayList<Taxable>(products.size());
		double totalTTC = 0;
		double totalTaxe = 0;

		for (Taxable product : products) {
			Taxable taxedProduct = taxeServices.taxe(product);
			
			double productTaxe = taxedProduct.getTaxe();
			totalTaxe += productTaxe;
			
			totalTTC += taxedProduct.getPrixTTC();

			taxedProducts.add(taxedProduct);
		}

		Command taxedCommand = Command.builder().id(command.getId())
												.products(taxedProducts)
												.build();
		
		Facture facture = Facture.builder().totalTaxes(totalTaxe)
										   .prixTTC(totalTTC)
										   .command(taxedCommand)
										   .build();

		return facture;
	}
}
