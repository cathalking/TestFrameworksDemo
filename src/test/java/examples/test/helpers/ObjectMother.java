package examples.test.helpers;

import static examples.domain.company.AccountStatus.ACTIVE;

import java.util.Arrays;

import examples.dao.OrdersDAO;
import examples.domain.company.AccountStatus;
import examples.domain.company.ClearingFirm;
import examples.domain.company.TradingAccount;
import examples.domain.company.TradingFirm;
import examples.domain.permission.Permission;
import examples.domain.securities.Future;
import examples.domain.securities.ISIN;
import examples.domain.trading.Order;
import examples.domain.user.Trader;
import examples.service.search.OrderSearchService;
import examples.service.search.OrderSearchServiceImpl;

public class ObjectMother {

	private static final String DEFAULT_ISIN_CODE = "ISIN";
	private static final String DEFAULT_FUTURE_DESC = "DESC";
	
	public static int price(int price) {
		return price;
	}

	public static int qty(int qty) {
		return qty;
	}

	public static OrdersDAOInMemory createOrdersDAO(Order order1, Order order2, Order order3, Order order4) {
		return new OrdersDAOInMemory(order1, order2, order3, order4);
	}

	public static OrderSearchService createOrderService(OrdersDAO ordersDAO) {
		OrderSearchService orderSearchService = new OrderSearchServiceImpl(ordersDAO);
		return orderSearchService;
	}
	
	private OrderSearchService prepareOrderService(Order order1, Order order2, Order order3, Order order4) {
		OrdersDAO orderDAO = createOrdersDAO(order1, order2, order3, order4);
		OrderSearchService orderSearchService = new OrderSearchServiceImpl(orderDAO);
		return orderSearchService;
	}

	private static int nextOrderId = 0;

	private static String nextOrderId() {
		return "ord:" + (++nextOrderId);
	}

	public static  Order createOrder(String accountCode, Future dummyFuture) {
		return createOrder(accountCode, dummyFuture, qty(0), price(0));
	}

	public static  Order createOrder(String accountCode, Future future, int qty, int price) {
		return new Order(nextOrderId(), accountCode, future, qty, price);
	}
	
	private Order createOrder(String orderId, TradingAccount tradingAcct, Future future, int qty, int price) {
		return new Order(orderId, tradingAcct.getTradingFirm().getCode(), future, qty, price);
	}

	public static  Future createFuture(String desc, String isinCode) {
		return new Future(desc, new ISIN(isinCode));
	}
	
	public static  Future createFuture(String isinCode) {
		return createFuture(DEFAULT_FUTURE_DESC, isinCode);
	}

	public static  Future dummyFuture() {
		return createFuture(DEFAULT_FUTURE_DESC, DEFAULT_ISIN_CODE);
	}
	
	private static Future DUMMY_FUTURE = new Future(DEFAULT_FUTURE_DESC, new ISIN(DEFAULT_ISIN_CODE));

	public static TradingAccount createTradingAccount(String accountCode) {
		return createTradingAccount(ACTIVE, accountCode);
	}

	public static  TradingAccount createTradingAccount(AccountStatus status, String tradingFirmCode) {
		TradingAccount tradingAcct = new TradingAccount(
				new TradingFirm(null, tradingFirmCode), new ClearingFirm(null, null), status);
		return tradingAcct;
	}
	
	public static  Trader createTraderWithPermissionsFor(TradingAccount tradingAccount) {
		Trader trader = new Trader();
		trader.setPermissions(Arrays.asList(new Permission(tradingAccount)));
		return trader;
	}
}
