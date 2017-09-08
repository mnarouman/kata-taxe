package my.toolkit.test.katataxe.domain.facture;

import java.util.List;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import my.toolkit.test.katataxe.domain.command.Command;
import my.toolkit.test.katataxe.services.taxe.Taxable;

@Builder
@Value
public class Facture {
	@NonNull
	private Command command;
	
	private double prixTTC;
	
	private double totalTaxes;

	public List<Taxable> getProducts() {
		return command.getProducts();
	}
}
