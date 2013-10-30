package examples.domain.trading;

import examples.domain.company.TradingAccount;
import examples.domain.securities.Product;

public class Order {

	public TradingAccount getTradingAccount() {
		return tradingAccount;
	}
	public Product getProduct() {
		return product;
	}
	public int getQty() {
		return qty;
	}
	public int getPrice() {
		return price;
	}
	public OrderState getState() {
		return state;
	}
	public Order(TradingAccount tradingAccount, Product product, int qty, int price) {
		this.tradingAccount = tradingAccount;
		this.product = product;
		this.qty = qty;
		this.price = price;
	}
	
	private TradingAccount tradingAccount;
	private Product product;
	private int qty;
	private int price;
	private OrderState state;
}
