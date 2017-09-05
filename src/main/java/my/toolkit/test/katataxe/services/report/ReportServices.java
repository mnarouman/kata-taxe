package my.toolkit.test.katataxe.services.report;

import java.text.DecimalFormat;
import java.text.NumberFormat;
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

	public String report(Product product) {
		double total = product.getPrixHT();
		String sTotal = format(total);
		double taxes = product.getTaxe();
		String sTaxe = format(taxes);
		String products = product.getName().concat(" : ").concat(sTotal).concat(sep);
		
		String report = products
				.concat("Montant des taxes : ").concat(sTaxe).concat(sep)
				.concat("Total : ").concat(sTotal);
		return report;
	}
}
