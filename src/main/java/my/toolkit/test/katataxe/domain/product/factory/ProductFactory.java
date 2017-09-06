/**
 * 
 */
package my.toolkit.test.katataxe.domain.product.factory;

import my.toolkit.test.katataxe.domain.product.DefaultProduct;
import my.toolkit.test.katataxe.domain.product.Livre;
import my.toolkit.test.katataxe.domain.product.Medicament;
import my.toolkit.test.katataxe.domain.product.Nourriture;
import javax.annotation.Generated;

/**
 * PatternBox: "ProductFactory" implementation.
 * <ul>
 *   <li>overrides the factory method to return an instance of a ConcreteProduct.</li>
 * </ul>
 * 
 * @author Dirk Ehms, <a href="http://www.patternbox.com">www.patternbox.com</a>
 * @author mnarouman
 */
public class ProductFactory extends AbstractProductFactory {

	@Generated("SparkTools")
	private ProductFactory(Builder builder) {
	}

	/** 
	 * Default constructor
	 */
	public ProductFactory() {
		super();
	}

	/** 
	 * This method returns a new instance of a ConcreteProduct implementation.
	 */
	public IProduct factoryMethod(ProductConfig productConfig) {
		Class<? extends IProduct> clazz = productConfig.getClazz();
		double prixHT = productConfig.getPrixHT();
		String productName = productConfig.getProductName();
		
		IProduct product = DefaultProduct.builder().withName(productName).withPrixHT(prixHT).build();
		
		if (Livre.class.equals(clazz)) {
			product = Livre.builder().withName(productName).withPrixHT(prixHT).build();
		}
		
		if (Nourriture.class.equals(clazz)) {
			product = Livre.builder().withName(productName).withPrixHT(prixHT).build();
		}

		if (Medicament.class.equals(clazz)) {
			product = Livre.builder().withName(productName).withPrixHT(prixHT).build();
		}

		return product;
	}

	/**
	 * Creates builder to build {@link ProductFactory}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link ProductFactory}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private Builder() {
		}

		public ProductFactory build() {
			return new ProductFactory(this);
		}
	}

}
