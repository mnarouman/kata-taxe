package my.toolkit.test.katataxe.services.taxe;

import my.toolkit.test.katataxe.domain.product.factory.IProduct;

/**
 * A taxe decorator interface
 * @author michel
 *
 */
public interface Taxable extends IProduct{
	double getTaxe();
	void setTaxe(double taxe);
	
	/**
	 * Compute prixTTC and the product taxe
	 */
	void applyTaxe();
}
