package my.toolkit.test.katataxe.domain.product.factory;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import my.toolkit.test.katataxe.services.taxe.Taxable;

@RequiredArgsConstructor
@Getter
public abstract class AbstractProduct implements Taxable {
	@NonNull
	private String name;

	@NonNull
	private double prixHT;
	
	@NonNull
	private boolean imported;

	@Setter
	private double prixTTC;
	
	@Setter
	private double taxe; 

	public boolean isExemptedTaxe() {
		return false;
	}
}