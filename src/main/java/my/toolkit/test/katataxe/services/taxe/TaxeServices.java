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
	private static final int TAXE_10_PERCENTS = 10;
	private static final int TAXE_5_PERCENTS = 5;
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
		double importedTaxe=0;
		if (product.isImported()) {
			importedTaxe = TAXE_5_PERCENTS;
		}
		
		double prixTTC = 0;
		double prixHT = product.getPrixHT();
		double taxe = 0;
		if (product.isExemptedTaxe()) {
			prixTTC = product.getPrixHT();
		} else {
			taxe = taxeProvider.roundTaxe((prixHT / 100) * TAXE_10_PERCENTS);
			prixTTC = taxeProvider.roundPrix(prixHT + taxe);
		}
		
		if (importedTaxe != 0) {
			double importedTaxeValue = taxeProvider.roundTaxe((prixHT / 100) * importedTaxe);
			prixTTC = taxeProvider.roundPrix(prixTTC + importedTaxeValue);
			
			taxe+= importedTaxeValue;
			
		}
		
		product.setPrixTTC(prixTTC);
		
		product = DefaultProduct.builder().withName(product.getName())
								   .withPrixHT(prixHT)
								   .withPrixTTC(prixTTC)
								   .withTaxe(taxe)
								   .build();
		
		return product;
	}

}
