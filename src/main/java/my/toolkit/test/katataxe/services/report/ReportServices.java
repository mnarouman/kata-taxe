package my.toolkit.test.katataxe.services.report;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import my.toolkit.test.katataxe.domain.command.Command;
import my.toolkit.test.katataxe.domain.facture.Facture;
import my.toolkit.test.katataxe.services.command.CommandServices;
import my.toolkit.test.katataxe.services.taxe.Taxable;

public class ReportServices {
	private String sep = System.getProperty("line.separator");
	private static final ReportServices INSTANCE = new ReportServices();

	private Locale locale = new Locale("en", "UK");
	private String pattern = "0.00";
	private DecimalFormat f = (DecimalFormat) NumberFormat.getNumberInstance(locale);

	private CommandServices commandServices = CommandServices.getUniqueInstance();

	private ReportServices() {
		super();
		f.applyPattern(pattern);
	}

	public static ReportServices getInstance() {
		return INSTANCE;
	}

	public String report(Command command) {

		Facture facture = commandServices.createFacture(command);

		List<Taxable> products = facture.getProducts();

		StringBuffer report = new StringBuffer();
		double totalTTC = facture.getPrixTTC();

		for (Taxable product : products) {
			double prixTTC = product.getPrixTTC();
			String sPrixTTC = format(prixTTC);
			
			String sProduct = product.getName().concat(" : ").concat(sPrixTTC).concat(sep);
			report.append(sProduct);
		}

		double totalTaxe = facture.getTotalTaxes();
		report.append("Montant des taxes : ").append(format(totalTaxe)).append(sep)
				.append("Total : ").append(format(totalTTC));
		return report.toString();
	}

	private String format(double d) {
		String doubleFormated = f.format(d);
		return doubleFormated;
	}

}
