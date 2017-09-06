package my.toolkit.test.katataxe.domain.command;

import java.util.List;

import javax.annotation.Generated;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import my.toolkit.test.katataxe.domain.product.factory.IProduct;

public class Command implements Comparable<Command> {
	private long id;
	private List<IProduct> products;

	@Generated("SparkTools")
	private Command(Builder builder) {
		this.id = builder.id;
		this.products = builder.products;
	}

	public List<IProduct> getProducts() {
		return products;
	}

	public long getId() {
		return id;
	}

	@Override
	public int compareTo(final Command other) {
		return ComparisonChain.start().compare(id, other.id).result();
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Command)) {
			return false;
		}
		Command castOther = (Command) other;
		return Objects.equal(id, castOther.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("products", products).toString();
	}

	/**
	 * Creates builder to build {@link Command}.
	 * 
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link Command}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private long id;
		private List<IProduct> products;

		private Builder() {
		}

		public Builder withId(long id) {
			this.id = id;
			return this;
		}

		public Builder withProducts(List<IProduct> products) {
			this.products = products;
			return this;
		}

		public Command build() {
			return new Command(this);
		}
	}
}
