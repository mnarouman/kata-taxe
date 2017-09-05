package my.toolkit.test.katataxe.domain.facture;

import java.util.List;

import javax.annotation.Generated;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import my.toolkit.test.katataxe.domain.command.Command;
import my.toolkit.test.katataxe.domain.product.Product;

public class Facture implements Comparable<Facture> {
	private long id;
	private Command command;
	private double prixHT;
	private double prixTTC;
	private double totalTaxes;

	@Generated("SparkTools")
	private Facture(Builder builder) {
		this.id = builder.id;
		this.command = builder.command;
		this.prixHT = builder.prixHT;
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
		private long id;
		private Command command;
		private double prixHT;
		private double prixTTC;
		private double totalTaxes;

		private Builder() {
		}

		public Builder withId(long id) {
			this.id = id;
			return this;
		}

		public Builder withCommand(Command command) {
			this.command = command;
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

		public Builder withTotalTaxes(double totalTaxes) {
			this.totalTaxes = totalTaxes;
			return this;
		}

		public Facture build() {
			return new Facture(this);
		}
	}

	@Override
	public int compareTo(final Facture other) {
		return ComparisonChain.start().compare(id, other.id).result();
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Facture)) {
			return false;
		}
		Facture castOther = (Facture) other;
		return Objects.equal(id, castOther.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("command", command).add("prixHT", prixHT).add("prixTTC", prixTTC).add("totalTaxes", totalTaxes).toString();
	}

	public long getId() {
		return id;
	}

	public Command getCommand() {
		return command;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public double getPrixTTC() {
		return prixTTC;
	}

	public List<Product> getProducts() {
		return command.getProducts();
	}

}
