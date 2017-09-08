package my.toolkit.test.katataxe.services.taxe;

import lombok.Getter;
import my.toolkit.test.katataxe.domain.product.factory.AbstractProduct;


public abstract class AbstractTaxable extends AbstractProduct implements Taxable {
	protected TaxeProvider taxeProvider = TaxeProvider.getUniqueInstance();
	
	@Getter
	private Taxable product;

	public AbstractTaxable(Taxable product) {
		super(product.getName(),product.getPrixHT(),product.isImported());
		this.product = product;
		setPrixTTC(product.getPrixTTC());
		setTaxe(product.getTaxe());
	}
}
