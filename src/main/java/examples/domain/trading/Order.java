package examples.domain.trading;

import examples.domain.company.TradingAccount;
import examples.domain.securities.Product;

public class Order {

	private String orderId;
	private TradingAccount tradingAccount;
	private Product product;
	private int qty;
	private int price;
	private OrderState state = OrderState.WORKING;

	public Order(String orderId, TradingAccount tradingAccount, Product product, int qty, int price) {
		this.orderId = orderId;
		this.tradingAccount = tradingAccount;
		this.product = product;
		this.qty = qty;
		this.price = price;
	}
	
	public String getOrderId() {
		return orderId;
	}
	
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

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", tradingAccount=" + tradingAccount + ", product=" + product + ", qty="
				+ qty + ", price=" + price + ", state=" + state + "]";
	}

}
