package my.toolkit.test.katataxe.services.taxe;

import my.toolkit.test.katataxe.domain.product.factory.AbstractProduct;
import com.google.common.base.MoreObjects;

public abstract class AbstractTaxable extends AbstractProduct implements Taxable {
	protected TaxeProvider taxeProvider = TaxeProvider.getUniqueInstance();
	private Taxable product;
	protected double taxe;

	public AbstractTaxable(Taxable product) {
		super();
		this.product = product;
		this.imported = product.isImported();
		this.name = product.getName();
		this.prixHT = product.getPrixHT();
		this.prixTTC = product.getPrixTTC();
		this.taxe = product.getTaxe();
	}

	@Override
	public double getTaxe() {
		return taxe;
	}

	@Override
	public void setTaxe(double taxe) {
		this.taxe = taxe;
	}

	protected Taxable getProduct() {
		return product;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("product", getProduct()).add("taxe", getTaxe()).toString();
	}

}
