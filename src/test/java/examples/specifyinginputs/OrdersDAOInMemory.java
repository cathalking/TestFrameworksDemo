package examples.specifyinginputs;

import java.util.Arrays;
import java.util.List;

import examples.dao.OrdersDAO;
import examples.domain.trading.Order;

public class OrdersDAOInMemory implements OrdersDAO {

	private List<Order> orders;

	public OrdersDAOInMemory(Order... orders) {
		this.orders = Arrays.asList(orders);
	}

	@Override
	public List<Order> getAll() {
		return orders;
	}

}
