package my.toolkit.test.katataxe.domain.product.factory;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import my.toolkit.test.katataxe.services.taxe.Taxable;

public abstract class AbstractProduct implements Comparable<AbstractProduct>, Taxable {

	protected String name = "";
	protected double prixHT;
	protected double prixTTC;
	protected boolean imported;
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
	public double getPrixTTC() {
		return prixTTC;
	}


	public boolean isExemptedTaxe() {
		return false;
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

	public boolean isImported() {
		return imported;
	}

	@Override
	public int compareTo(final AbstractProduct other) {
		return ComparisonChain.start().compare(name, other.name).result();
	}

	public double getTaxe() {
		return taxe;
	}

	public void setTaxe(double taxe) {
		this.taxe = taxe;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("name", name).add("prixHT", prixHT).add("prixTTC", prixTTC).add("imported", imported).add("taxe", taxe).toString();
	}

}