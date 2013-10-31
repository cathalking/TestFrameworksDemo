package examples.service.search;

import java.util.ArrayList;
import java.util.List;

import examples.dao.OrdersDAO;
import examples.domain.company.TradingAccount;
import examples.domain.permission.Permission;
import examples.domain.trading.Order;
import examples.domain.user.Trader;
import examples.domain.user.User;
import examples.service.permission.PermissionService;

public class OrderSearchServiceImplV2 implements OrderSearchService {
	
	private OrdersDAO ordersDAO;
	private PermissionService permissionService;

	public OrderSearchServiceImplV2(OrdersDAO orderDAO) {
		this.ordersDAO = orderDAO;
	}

	@Override
	public List<Order> getOrders(Trader trader, String accountCode, String isinCode) {
		List<Order> matchingOrders = new ArrayList<>();
		for (Order order : ordersDAO.findBy(accountCode, isinCode)) {
			if (permissionService.hasViewPermissions(trader, order)) {
				matchingOrders.add(order);
			}
		}
		return matchingOrders;
	}


	@Override
	public List<Order> getOrders(Trader trader, String accountCode) {
		List<Order> matchingOrders = new ArrayList<>();
		for (Order order : ordersDAO.findBy(accountCode)) {
			if (permissionService.hasViewPermissions(trader, order)) {
				matchingOrders.add(order);
			}
		}
		return matchingOrders;
	}

}
