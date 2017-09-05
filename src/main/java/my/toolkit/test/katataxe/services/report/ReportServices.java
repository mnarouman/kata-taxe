package my.toolkit.test.katataxe.services.report;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ReportServices {
	private String sep = System.getProperty("line.separator");
	private static final ReportServices INSTANCE = new ReportServices();

	private ReportServices() {
		super();
	}

	public static ReportServices getInstance() {
		return INSTANCE;
	}

	public String report(double taxes, double total) {
		Locale locale  = new Locale("en", "UK");
		String pattern = "0.00";

		DecimalFormat f = (DecimalFormat)NumberFormat.getNumberInstance(locale);
		f.applyPattern(pattern);
		
		String sTotal = f.format(total);
		String sTaxe = f.format(taxes);
		String report = "Montant des taxes : ".concat(sTaxe).concat(sep)
				.concat("Total : ").concat(sTotal);
		return report;
	}
}
