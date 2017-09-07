/**
 * 
 */
package my.toolkit.test.katataxe.services.taxe;

import my.toolkit.test.katataxe.services.taxe.impl.ImportedTaxe;
import my.toolkit.test.katataxe.services.taxe.impl.Tva;

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
	
	public Taxable taxe(Taxable product) {
		if (!product.isExemptedTaxe()) {
			product = new Tva(product);
		}
		
		if (product.isImported()) {
			product = new ImportedTaxe(product);
		}
	
		product.applyTaxe();
		
		return product;
	}
}
