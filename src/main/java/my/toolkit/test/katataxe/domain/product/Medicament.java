package my.toolkit.test.katataxe.domain.product;

import javax.annotation.Generated;

public class Medicament extends AbstractProduct {

	@Generated("SparkTools")
	private Medicament(Builder builder) {
		this.name = builder.name;
		this.prixHT = builder.prixHT;
		this.prixTTC = builder.prixTTC;
		this.taxe = builder.taxe;
	}

	/**
	 * Creates builder to build {@link Medicament}.
	 * 
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link Medicament}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String name;
		private double prixHT;
		private double prixTTC;
		private double taxe;

		private Builder() {
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withPrixHT(double prixHT) {
			this.prixHT = prixHT;
			return this;
		}

		public Builder withPrixTTC(double prixTTC) {
			this.prixTTC = prixTTC;
			return this;
		}

		public Builder withTaxe(double taxe) {
			this.taxe = taxe;
			return this;
		}

		public Medicament build() {
			return new Medicament(this);
		}
	}

	@Override
	public boolean isExemptedTaxe() {
		return true;
	}

}
