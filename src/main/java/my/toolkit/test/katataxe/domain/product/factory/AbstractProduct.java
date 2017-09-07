package my.toolkit.test.katataxe.domain.product.factory;

import my.toolkit.test.katataxe.services.taxe.Taxable;

public abstract class AbstractProduct implements Taxable {

	protected String name = "";
	protected double prixHT;
	protected double prixTTC;
	protected boolean imported;
	protected double taxe; 

	public AbstractProduct() {
		super();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getPrixHT() {
		return prixHT;
	}

	@Override
	public double getPrixTTC() {
		return prixTTC;
	}


	public boolean isExemptedTaxe() {
		return false;
	}

	public void setPrixTTC(double prixTTC) {
		this.prixTTC = prixTTC;
	}

	public boolean isImported() {
		return imported;
	}

	public double getTaxe() {
		return taxe;
	}

	public void setTaxe(double taxe) {
		this.taxe = taxe;
	}
}