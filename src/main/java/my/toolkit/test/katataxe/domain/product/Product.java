package my.toolkit.test.katataxe.domain.product;

import javax.annotation.Generated;
import com.google.common.base.Objects;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;

public class Product implements Comparable<Product> {

	private String name = "";
	private double prixHT;
	private double prixTTC;
	private double taxe;

	@Generated("SparkTools")
	private Product(Builder builder) {
		this.name = builder.name;
		this.prixHT = builder.prixHT;
		this.prixTTC = builder.prixTTC;
		this.taxe = builder.taxe;
	}

	public String getName() {
		return name;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public double getTaxe() {
		return taxe;
	}

	@Override
	public int compareTo(final Product other) {
		return ComparisonChain.start().compare(name, other.name).compare(prixHT, other.prixHT).compare(taxe, other.taxe).result();
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Product)) {
			return false;
		}
		Product castOther = (Product) other;
		return Objects.equal(name, castOther.name) && Objects.equal(prixHT, castOther.prixHT) && Objects.equal(taxe, castOther.taxe);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name, prixHT, taxe);
	}

	public double getPrixTTC() {
		return prixTTC;
	}

	/**
	 * Creates builder to build {@link Product}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link Product}.
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

		public Product build() {
			return new Product(this);
		}
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("name", name).add("prixHT", prixHT).add("prixTTC", prixTTC).add("taxe", taxe).toString();
	}

}
