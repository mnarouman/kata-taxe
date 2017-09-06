/**
 * 
 */
package my.toolkit.test.katataxe.services.facture;

import java.util.ArrayList;
import java.util.List;

import my.toolkit.test.katataxe.domain.command.Command;
import my.toolkit.test.katataxe.domain.facture.Facture;
import my.toolkit.test.katataxe.domain.product.Product;
import my.toolkit.test.katataxe.services.taxe.TaxeProvider;

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
	private TaxeProvider taxeProvider = TaxeProvider.getUniqueInstance();

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
		List<Product> taxedProducts = new ArrayList<Product>(products.size());
		double totalHT = 0;
		double totalTTC = 0;
		double totalTaxe = 0;

		for (Product product : products) {

			double prixHT = product.getPrixHT();
			totalHT += prixHT;
			
			Product taxedProduct = taxe(product);
			
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

	public Product taxe(Product product) {
		
		double prixHT = product.getPrixHT();
		
		double taxe = taxeProvider.roundTaxe((prixHT / 100) * 10);
		double prixTTC = taxeProvider.roundPrix(prixHT + taxe);
		
		product = Product.builder().withName(product.getName())
								   .withPrixHT(prixHT)
								   .withPrixTTC(prixTTC)
								   .withTaxe(taxe)
								   .build();
		
		return product;
	}

}
