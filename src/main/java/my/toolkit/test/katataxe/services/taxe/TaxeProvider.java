/**
 * 
 */
package my.toolkit.test.katataxe.services.taxe;

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
public class TaxeProvider {

	/** unique instance */
	private static final TaxeProvider sInstance = new TaxeProvider();

	/** 
	 * Private constuctor
	 */
	private TaxeProvider() {
		super();
	}

	/** 
	 * Get the unique instance of this class.
	 */
	public static synchronized TaxeProvider getUniqueInstance() {
		return sInstance;
	}

	public double roundTaxe(double taxe) {
		double roundedTaxe = roundPrix(taxe);
		roundedTaxe = roundUp5Cents(roundedTaxe);
		return roundedTaxe;
	}

	public double roundPrix(double taxe) {
		if (taxe % 1 != 0) {
			double nbApVirg = 2;
			taxe = (double)((int)(taxe * Math.pow(10,nbApVirg ) + .5)) / Math.pow(10,nbApVirg);
		}
		return taxe;
	}

	private double roundUp5Cents(double taxe) {
		double nbApVirg = 2;
		if (taxe % 5 != 0 && taxe % 5 != 5) {

			double tmp = ((double) (long) (taxe * 20)) / 20;

			if (taxe > tmp) {
				taxe = tmp + 0.05;
			}
			taxe = (double)((int)(taxe * Math.pow(10,nbApVirg ) + .5)) / Math.pow(10,nbApVirg);
		}
		return taxe;
	}
}
