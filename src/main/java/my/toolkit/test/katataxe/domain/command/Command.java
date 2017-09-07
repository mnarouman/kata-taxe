package my.toolkit.test.katataxe.domain.command;

import java.util.List;

import javax.annotation.Generated;

import my.toolkit.test.katataxe.services.taxe.Taxable;

public class Command {
	private long id;
	private List<Taxable> products;

	@Generated("SparkTools")
	private Command(Builder builder) {
		this.id = builder.id;
		this.products = builder.products;
	}

	public List<Taxable> getProducts() {
		return products;
	}

	public long getId() {
		return id;
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
		private List<Taxable> products;

		private Builder() {
		}

		public Builder withId(long id) {
			this.id = id;
			return this;
		}

		public Builder withProducts(List<Taxable> products) {
			this.products = products;
			return this;
		}

		public Command build() {
			return new Command(this);
		}
	}
}
