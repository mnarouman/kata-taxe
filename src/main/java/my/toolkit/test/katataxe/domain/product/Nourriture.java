package my.toolkit.test.katataxe.domain.product;

import lombok.Builder;
import my.toolkit.test.katataxe.domain.product.factory.AbstractProduct;

public class Nourriture extends AbstractProduct {
	@Builder
	private Nourriture(String name, double prixHT, boolean imported) {
		super(name, prixHT, imported);
	}

	@Override
	public void applyTaxe() {
		setPrixTTC(getPrixHT());
	}
	
	@Override
	public boolean isExemptedTaxe() {
		return true;
	}
}
