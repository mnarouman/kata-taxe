package my.toolkit.test.katataxe.services.report;

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
		return "Montant des taxes : 0.00" + sep +
				"Total : 00.00";
	}
}
