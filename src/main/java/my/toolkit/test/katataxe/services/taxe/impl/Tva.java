package my.toolkit.test.katataxe.services.taxe.impl;

import my.toolkit.test.katataxe.services.taxe.AbstractTaxable;
import my.toolkit.test.katataxe.services.taxe.Taxable;

public class Tva extends AbstractTaxable{
	private static final int TVA_VALUE = 10;

	public Tva(Taxable product) {
		super(product);
		setTaxe(TVA_VALUE);
	}

	@Override
	public void applyTaxe() {
		Taxable product = getProduct();
		
		product.applyTaxe();
		
		double taxeValue = taxeProvider.roundTaxe((product.getPrixHT() / 100) * getTaxe());
		double prixTTC = taxeProvider.roundPrix(product.getPrixHT() + taxeValue);
		
		setPrixTTC(prixTTC);
		setTaxe(taxeValue);
		
	}
}
