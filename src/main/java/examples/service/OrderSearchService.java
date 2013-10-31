package examples.service;

import java.util.List;

import examples.domain.trading.Order;
import examples.domain.user.Trader;

public interface OrderSearchService {

	public List<Order> getOrders(Trader trader, String accountCode, String isinCode);

	public List<Order> getOrders(Trader trader, String searchAccountCode);

}