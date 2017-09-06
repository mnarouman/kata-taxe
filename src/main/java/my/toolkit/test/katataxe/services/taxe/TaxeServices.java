/**
 * 
 */
package my.toolkit.test.katataxe.services.taxe;

import my.toolkit.test.katataxe.domain.product.DefaultProduct;
import my.toolkit.test.katataxe.domain.product.factory.IProduct;

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
public class TaxeServices {
	private TaxeProvider taxeProvider = TaxeProvider.getUniqueInstance();
	/** unique instance */
	private static final TaxeServices sInstance = new TaxeServices();

	/** 
	 * Private constuctor
	 */
	private TaxeServices() {
		super();
	}

	/** 
	 * Get the unique instance of this class.
	 */
	public static synchronized TaxeServices getUniqueInstance() {
		return sInstance;
	}

	public IProduct taxe(IProduct product) {
		if (product.isExemptedTaxe()) {
			product.setPrixTTC(product.getPrixHT());
			return product;
		}
		double prixHT = product.getPrixHT();
		
		double taxe = taxeProvider.roundTaxe((prixHT / 100) * 10);
		double prixTTC = taxeProvider.roundPrix(prixHT + taxe);
		
		product = DefaultProduct.builder().withName(product.getName())
								   .withPrixHT(prixHT)
								   .withPrixTTC(prixTTC)
								   .withTaxe(taxe)
								   .build();
		
		return product;
	}

}
