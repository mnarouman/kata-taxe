package my.toolkit.test.katataxe.domain.product;

public interface IProduct {

	String getName();

	double getPrixHT();

	double getTaxe();

	double getPrixTTC();
	
	boolean isExemptedTaxe();

	void setPrixTTC(double prixHT);

}