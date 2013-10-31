package examples.domain.permission;

import examples.domain.securities.Product;

public class Restriction {

	private Product product;
	
	public Restriction(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}
	
}
