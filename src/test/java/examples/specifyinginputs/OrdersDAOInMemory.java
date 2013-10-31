package examples.specifyinginputs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import examples.dao.OrdersDAO;
import examples.domain.company.TradingAccount;
import examples.domain.trading.Order;

public class OrdersDAOInMemory implements OrdersDAO {

	private List<Order> orders;

	public OrdersDAOInMemory(Order... orders) {
		this.orders = Arrays.asList(orders);
	}

	@Override
	public List<Order> findBy(String accountCode) {
		List<Order> matchingOrders = new ArrayList<>();
		for(Order order: orders) {
			if (accountCode.equals(order.getAccountCode())) {
				matchingOrders.add(order);
			}
		}
		return matchingOrders;
	}
	
	public List<Order> findBy(String accountCode, String isinCode) {
		List<Order> matchingOrders = new ArrayList<>();
		for(Order order: orders) {
			if (accountCode.equals(order.getAccountCode())
					&& isinCode.equals(order.getProduct().getIsinCode())) {
				matchingOrders.add(order);
			}
		}
		return matchingOrders;
	}

}
