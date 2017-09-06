package my.toolkit.test.katataxe.domain.product.factory;

import javax.annotation.Generated;

public class ProductConfig {
	private Class<? extends IProduct> clazz;
	private String productName;
	private double prixHT;

	@Generated("SparkTools")
	private ProductConfig(Builder builder) {
		this.clazz = builder.clazz;
		this.productName = builder.productName;
		this.prixHT = builder.prixHT;
	}

	public Class<? extends IProduct> getClazz() {
		return clazz;
	}

	public String getProductName() {
		return productName;
	}

	public double getPrixHT() {
		return prixHT;
	}

	/**
	 * Creates builder to build {@link ProductConfig}.
	 * 
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link ProductConfig}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private Class<? extends IProduct> clazz;
		private String productName;
		private double prixHT;

		private Builder() {
		}

		public Builder withClazz(Class<? extends IProduct> clazz) {
			this.clazz = clazz;
			return this;
		}

		public Builder withProductName(String productName) {
			this.productName = productName;
			return this;
		}

		public Builder withPrixHT(double prixHT) {
			this.prixHT = prixHT;
			return this;
		}

		public ProductConfig build() {
			return new ProductConfig(this);
		}
	}

}
