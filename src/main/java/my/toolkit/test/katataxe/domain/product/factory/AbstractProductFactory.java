/**
 * 
 */
package my.toolkit.test.katataxe.domain.product.factory;

import my.toolkit.test.katataxe.services.taxe.Taxable;

/**
 * PatternBox: "Creator" implementation.
 * <ul>
 *   <li>declares the factory method, which returns an object of type IProduct. Creator may also define a default implementation of the factory method that returns a default ConcreteProduct object.</li>
 *   <li>may call the factory method to create a IProduct object.</li>
 * </ul>
 * 
 * @author Dirk Ehms, <a href="http://www.patternbox.com">www.patternbox.com</a>
 * @author mnarouman
 */
public abstract class AbstractProductFactory {

	/** 
	 * The ProductFactory implementation have to return a ConcreteProduct.
	 */
	public abstract Taxable factoryMethod(ProductConfig productConfig);

}
