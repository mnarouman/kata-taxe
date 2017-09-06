package my.toolkit.test.katataxe.domain.product;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class AbstractProduct implements Comparable<AbstractProduct>, IProduct {

	protected String name = "";
	protected double prixHT;
	protected double prixTTC;
	protected double taxe;

	public AbstractProduct() {
		super();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getPrixHT() {
		return prixHT;
	}

	@Override
	public double getTaxe() {
		return taxe;
	}


	@Override
	public double getPrixTTC() {
		return prixTTC;
	}

	@Override
	public int compareTo(final AbstractProduct other) {
		return ComparisonChain.start().compare(getName(), other.getName()).compare(getPrixHT(), other.getPrixHT()).compare(getPrixTTC(), other.getPrixTTC()).compare(getTaxe(), other.getTaxe()).result();
	}

	public boolean isExemptedTaxe() {
		return false;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("name", name).add("prixHT", prixHT).add("prixTTC", prixTTC).add("taxe", taxe).add("exemptedTaxe", isExemptedTaxe()).toString();
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof AbstractProduct)) {
			return false;
		}
		AbstractProduct castOther = (AbstractProduct) other;
		return Objects.equal(name, castOther.name);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name);
	}

	public void setPrixTTC(double prixTTC) {
		this.prixTTC = prixTTC;
	}

}