package examples.service;

import java.util.ArrayList;
import java.util.List;

import examples.dao.OrdersDAO;
import examples.domain.company.TradingAccount;
import examples.domain.trading.Order;
import examples.domain.user.Trader;
import examples.domain.user.User;
import examples.domain.user.permission.Permission;

public class OrderSearchServiceImpl implements OrderSearchService {
	
	private OrdersDAO ordersDAO;

	public OrderSearchServiceImpl(OrdersDAO orderDAO) {
		this.ordersDAO = orderDAO;
	}

	@Override
	public List<Order> getOrders(Trader trader, TradingAccount tradingAccount, String isinCode) {
		List<Order> matchingOrders = new ArrayList<>();
		for (Order order : ordersDAO.getAll()) {
			if(isMatchingOrder(order, tradingAccount, isinCode)) {
				if (traderHasAccountPermissions(trader, order)) {
					matchingOrders.add(order);
				}
			}
		}
		return matchingOrders;
	}

	private boolean traderHasAccountPermissions(Trader trader, Order order) {
		for (Permission permission : trader.getPermissions()) {
			if (permission.getTradingAccount().equals(order.getTradingAccount()))
				return true;
		}
		return false;
	}

	private boolean isMatchingOrder(Order order, TradingAccount tradingAccount, String isinCode) {
		return order.getTradingAccount().equals(tradingAccount) 
				&& order.getProduct().getIsinCode().equals(isinCode);
	}
}
