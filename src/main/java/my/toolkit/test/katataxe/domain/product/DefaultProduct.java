package my.toolkit.test.katataxe.domain.product;

import lombok.Builder;
import my.toolkit.test.katataxe.domain.product.factory.AbstractProduct;

public class DefaultProduct extends AbstractProduct {
	@Builder
	private DefaultProduct(String name, double prixHT, boolean imported) {
		super(name, prixHT, imported);
	}

	@Override
	public void applyTaxe() {
	}
}
