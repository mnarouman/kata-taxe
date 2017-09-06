/**
 * 
 */
package my.toolkit.test.katataxe.services.facture;

import java.util.ArrayList;
import java.util.List;

import my.toolkit.test.katataxe.domain.command.Command;
import my.toolkit.test.katataxe.domain.facture.Facture;
import my.toolkit.test.katataxe.domain.product.DefaultProduct;
import my.toolkit.test.katataxe.domain.product.factory.IProduct;
import my.toolkit.test.katataxe.services.taxe.TaxeProvider;
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
		List<IProduct> products = command.getProducts();
		List<IProduct> taxedProducts = new ArrayList<IProduct>(products.size());
		double totalHT = 0;
		double totalTTC = 0;
		double totalTaxe = 0;

		for (IProduct product : products) {

			double prixHT = product.getPrixHT();
			totalHT += prixHT;
			
			IProduct taxedProduct = taxeServices.taxe(product);
			
			double productTaxe = taxedProduct.getTaxe();
			totalTaxe += productTaxe;
			
			totalTTC += taxedProduct.getPrixTTC();

			taxedProducts.add(taxedProduct);
		}

		Command taxedCommand = Command.builder().withId(command.getId())
												.withProducts(taxedProducts)
												.build();
		
		Facture facture = Facture.builder().withId(command.getId())
										   .withPrixHT(totalHT)
										   .withTotalTaxes(totalTaxe)
										   .withPrixTTC(totalTTC)
										   .withCommand(taxedCommand)
										   .build();

		return facture;
	}

	

}
