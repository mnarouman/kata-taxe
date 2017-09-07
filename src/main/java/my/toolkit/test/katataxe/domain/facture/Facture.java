package my.toolkit.test.katataxe.domain.facture;

import java.util.List;

import javax.annotation.Generated;

import my.toolkit.test.katataxe.domain.command.Command;
import my.toolkit.test.katataxe.services.taxe.Taxable;

public class Facture {
	private Command command;
	private double prixTTC;
	private double totalTaxes;

	@Generated("SparkTools")
	private Facture(Builder builder) {
		this.command = builder.command;
		this.prixTTC = builder.prixTTC;
		this.totalTaxes = builder.totalTaxes;
	}

	public double getTotalTaxes() {
		return totalTaxes;
	}

	/**
	 * Creates builder to build {@link Facture}.
	 * 
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link Facture}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private Command command;
		private double prixTTC;
		private double totalTaxes;

		private Builder() {
		}

		public Builder withCommand(Command command) {
			this.command = command;
			return this;
		}

		public Builder withPrixTTC(double prixTTC) {
			this.prixTTC = prixTTC;
			return this;
		}

		public Builder withTotalTaxes(double totalTaxes) {
			this.totalTaxes = totalTaxes;
			return this;
		}

		public Facture build() {
			return new Facture(this);
		}
	}

	public double getPrixTTC() {
		return prixTTC;
	}

	public List<Taxable> getProducts() {
		return command.getProducts();
	}

}
