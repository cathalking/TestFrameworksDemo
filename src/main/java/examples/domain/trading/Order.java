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
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + price;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + qty;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((tradingAccount == null) ? 0 : tradingAccount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (price != other.price)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (qty != other.qty)
			return false;
		if (state != other.state)
			return false;
		if (tradingAccount == null) {
			if (other.tradingAccount != null)
				return false;
		} else if (!tradingAccount.equals(other.tradingAccount))
			return false;
		return true;
	}

}
