/**
 * 
 */
package my.toolkit.test.katataxe.services.command;

import my.toolkit.test.katataxe.domain.command.Command;
import my.toolkit.test.katataxe.domain.facture.Facture;
import my.toolkit.test.katataxe.services.facture.FactureServices;

/**
 * PatternBox: "Singleton" implementation.
 * <ul>
 * <li>defines an Instance operation that lets clients access its unique
 * instance. Instance is a class operation</li>
 * <li>may be responsible for creating its own unique instance.</li>
 * </ul>
 * 
 * @author Dirk Ehms, <a href="http://www.patternbox.com">www.patternbox.com</a>
 * @author mnarouman
 */
public class CommandServices {

	/** unique instance */
	private static final CommandServices sInstance = new CommandServices();
	
	private FactureServices factureServices = FactureServices.getUniqueInstance();

	/**
	 * Private constuctor
	 */
	private CommandServices() {
		super();
	}

	/**
	 * Get the unique instance of this class.
	 */
	public static synchronized CommandServices getUniqueInstance() {

		return sInstance;

	}

	public Facture createFacture(Command command) {
		return factureServices.createFacture(command);
	}

}
