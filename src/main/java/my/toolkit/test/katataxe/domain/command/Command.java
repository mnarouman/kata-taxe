package my.toolkit.test.katataxe.domain.command;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import my.toolkit.test.katataxe.services.taxe.Taxable;

@Builder
@Getter
public class Command {
	private long id;
	private List<Taxable> products;
}
