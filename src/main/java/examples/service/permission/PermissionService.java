package examples.service.permission;

import examples.domain.trading.Order;
import examples.domain.user.Trader;

public interface PermissionService {

	boolean hasViewPermissions(Trader trader, Order order);
}
