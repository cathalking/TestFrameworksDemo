package examples.test.builders;

import tradingapp.domain.permission.Restriction;
import tradingapp.domain.securities.Product;
import static examples.test.builders.FutureBuilder.*;

public class RestrictionBuilder {

	private Product product = aFuture().build();

	private RestrictionBuilder() { }
	
	public static RestrictionBuilder aRestriction() {
		return new RestrictionBuilder();
	}
	
	public RestrictionBuilder withProduct(Product product) {
		this.product = product;
		return this;
	}
	
	public Restriction build() {
		Restriction Restriction = new Restriction(product);
		return Restriction;
	}
	
	public RestrictionBuilder but() {
		return new RestrictionBuilder()
							.withProduct(product);
	}
}
