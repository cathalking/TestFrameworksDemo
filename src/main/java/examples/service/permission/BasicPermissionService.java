package examples.service.permission;

import examples.domain.company.TradingAccount;
import examples.domain.permission.Permission;
import examples.domain.trading.Order;
import examples.domain.user.Trader;

public class BasicPermissionService implements PermissionService {

	public boolean hasViewPermissions(Trader trader, Order order) {
		for (Permission permission : trader.getPermissions()) {
			TradingAccount tradingAccount = permission.getTradingAccount();
			if (permission.getTradingAccount().isActive()
					&& tradingAccount.getTradingFirm().getCode().equals(order.getAccountCode()))
				return true;
		}
		return false;
	}

}
