package my.toolkit.test.katataxe.domain.product;

import javax.annotation.Generated;

import my.toolkit.test.katataxe.domain.product.factory.AbstractProduct;

public class DefaultProduct extends AbstractProduct {

	@Generated("SparkTools")
	private DefaultProduct(Builder builder) {
		this.name = builder.name;
		this.prixHT = builder.prixHT;
		this.prixTTC = builder.prixTTC;
		this.taxe = builder.taxe;
		this.imported = builder.imported;
	}

	/**
	 * Creates builder to build {@link DefaultProduct}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link DefaultProduct}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String name;
		private double prixHT;
		private double prixTTC;
		private double taxe;
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

		public Builder withTaxe(double taxe) {
			this.taxe = taxe;
			return this;
		}

		public Builder withImported(boolean imported) {
			this.imported = imported;
			return this;
		}

		public DefaultProduct build() {
			return new DefaultProduct(this);
		}
	}

	

}
