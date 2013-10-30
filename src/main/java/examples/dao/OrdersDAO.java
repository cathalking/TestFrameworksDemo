package examples.dao;

import java.util.List;

import examples.domain.trading.Order;

public interface OrdersDAO {

	public List<Order> getAll();
}
