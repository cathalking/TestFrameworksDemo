package examples.dao;

import java.util.List;

import examples.domain.company.TradingAccount;
import examples.domain.trading.Order;

public interface OrdersDAO {

	public List<Order> findBy(String accountCode);
	public List<Order> findBy(String accountCode, String isinCode);
}
