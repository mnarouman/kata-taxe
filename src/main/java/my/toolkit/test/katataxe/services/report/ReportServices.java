package my.toolkit.test.katataxe.services.report;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

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

	public String report(double taxes, double total) {
		String sTotal = format(total);
		String sTaxe = format(taxes);
		String report = "Montant des taxes : ".concat(sTaxe).concat(sep)
				.concat("Total : ").concat(sTotal);
		return report;
	}

	private String format(double d) {
		String doubleFormated = f.format(d);
		return doubleFormated;
	}
}
