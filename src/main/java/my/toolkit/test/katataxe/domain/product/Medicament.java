package my.toolkit.test.katataxe.domain.product;

import javax.annotation.Generated;

import my.toolkit.test.katataxe.domain.product.factory.AbstractProduct;

public class Medicament extends AbstractProduct {

	@Generated("SparkTools")
	private Medicament(Builder builder) {
		this.name = builder.name;
		this.prixHT = builder.prixHT;
		this.prixTTC = builder.prixTTC;
		this.imported = builder.imported;
		this.taxe = builder.taxe;
	}

	@Override
	public boolean isExemptedTaxe() {
		return true;
	}

	/**
	 * Creates builder to build {@link Medicament}.
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
		private boolean imported;
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

		public Builder withImported(boolean imported) {
			this.imported = imported;
			return this;
		}

		public Medicament build() {
			return new Medicament(this);
		}
	}


	@Override
	public void applyTaxe() {
		this.prixTTC = this.prixHT;
	}

}
