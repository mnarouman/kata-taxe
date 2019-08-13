package my.toolkit.test.katataxe.domain.product.factory;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@Builder
@Value
@EqualsAndHashCode
@ToString
public class ProductConfig {
	private Class<? extends IProduct> productType;
	private String productName;
	private double prixHT;
	private boolean imported;
}
