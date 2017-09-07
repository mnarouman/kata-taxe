package my.toolkit.test.katataxe.domain.product;

import javax.annotation.Generated;

import my.toolkit.test.katataxe.domain.product.factory.AbstractProduct;

public class Nourriture extends AbstractProduct {

	
	@Generated("SparkTools")
	private Nourriture(Builder builder) {
		this.name = builder.name;
		this.prixHT = builder.prixHT;
		this.prixTTC = builder.prixTTC;
		this.imported = builder.imported;
	}

	@Override
	public boolean isExemptedTaxe() {
		return true;
	}

	/**
	 * Creates builder to build {@link Nourriture}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link Nourriture}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String name;
		private double prixHT;
		private double prixTTC;
		private boolean imported;

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

		public Builder withImported(boolean imported) {
			this.imported = imported;
			return this;
		}

		public Nourriture build() {
			return new Nourriture(this);
		}
	}

	@Override
	public void applyTaxe() {
		this.prixTTC = this.prixHT;
	}
}
