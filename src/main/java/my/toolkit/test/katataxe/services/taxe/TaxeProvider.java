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

	/** 
	 * This is just a dummy method that can be called by the client. Replace
	 * this method by another one which you really need.
	 */
	public void doSomething() {
	}

	public double round(double input) {
		return 1.00;
	}

}
