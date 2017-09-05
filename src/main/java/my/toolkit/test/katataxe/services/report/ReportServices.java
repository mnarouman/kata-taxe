package my.toolkit.test.katataxe.services.report;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import my.toolkit.test.katataxe.domain.product.Product;

public class ReportServices {
	private String sep = System.getProperty("line.separator");
	private static final ReportServices INSTANCE = new ReportServices();

	private Locale locale = new Locale("en", "UK");
	private String pattern = "0.00";
	private DecimalFormat f = (DecimalFormat) NumberFormat.getNumberInstance(locale);

	private ReportServices() {
		super();
		f.applyPattern(pattern);
	}

	public static ReportServices getInstance() {
		return INSTANCE;
	}

	private String format(double d) {
		String doubleFormated = f.format(d);
		return doubleFormated;
	}

	public String report(List<Product> products2) {
		StringBuffer report = new StringBuffer();
		double totalHT = 0;
		double totalTaxe = 0;
		
		for (Product product : products2) {
			
			double prixHT = product.getPrixHT();
			totalHT += prixHT;
			String sPrixHT = format(prixHT);
			
			double productTaxe = product.getTaxe();
			totalTaxe += productTaxe;

			String sProduct = product.getName().concat(" : ").concat(sPrixHT).concat(sep);
			report.append(sProduct);
		}
		
		report.append("Montant des taxes : ").append(format(totalTaxe)).append(sep)
				.append("Total : ").append(format(totalHT));
		return report.toString();
	}
}
