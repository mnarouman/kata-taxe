/**
 * 
 */
package my.toolkit.test.katataxe.domain.product.factory;

/**
 * PatternBox: "IProduct" implementation.
 * <ul>
 *   <li>defines the interface of objects the factory method creates.</li>
 * </ul>
 * 
 * @author Dirk Ehms, <a href="http://www.patternbox.com">www.patternbox.com</a>
 * @author mnarouman
 */
public interface IProduct{
	String getName();

	double getPrixHT();

//	double getTaxe();

	double getPrixTTC();
	
	boolean isExemptedTaxe();
	
	boolean isImported();

	void setPrixTTC(double prixHT);

}
