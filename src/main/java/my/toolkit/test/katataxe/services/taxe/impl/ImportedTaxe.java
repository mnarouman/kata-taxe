package my.toolkit.test.katataxe.services.taxe.impl;

import my.toolkit.test.katataxe.services.taxe.AbstractTaxable;
import my.toolkit.test.katataxe.services.taxe.Taxable;

public class ImportedTaxe extends AbstractTaxable{
	private static final int IMPORTED_TAXE_VALUE = 5;

	public ImportedTaxe(Taxable product) {
		super(product);
		setTaxe(IMPORTED_TAXE_VALUE);
	}

	@Override
	public void applyTaxe() {
		Taxable product = getProduct();
		
		product.applyTaxe();

		double taxeValue = taxeProvider.roundTaxe((product.getPrixHT() / 100) * getTaxe());
		double prixTTC = taxeProvider.roundPrix(product.getPrixTTC() + taxeValue);
		setPrixTTC(prixTTC);
		
		double currentTaxe = product.getTaxe();
		setTaxe(currentTaxe + taxeValue);
	}
}
