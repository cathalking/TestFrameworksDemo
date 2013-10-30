package examples.specifyinginputs;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.fest.assertions.api.Assertions.*;
import static examples.assertions.custom.ProjectAssertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import examples.dao.OrdersDAO;
import examples.domain.company.TradingAccount;
import examples.domain.securities.Future;
import examples.domain.securities.Product;
import examples.domain.trading.Order;
import examples.domain.user.Trader;
import examples.domain.user.User;
import examples.domain.user.permission.Permission;
import examples.service.OrderSearchService;
import examples.service.OrderSearchServiceImpl2;

public class SpecifyingInputsTest {

	@Test
	public void getOrders_GivenTraderWithAccountPermissions_SearchingByThatAccountAndIsin_ThenReturnsMatchingOrders() {
		// given
		Trader trader = new Trader();
		TradingAccount tradingAccount = new TradingAccount();
		String coffeeIsinCode = "COF24680";
		trader.setPermissions(Arrays.asList(new Permission(tradingAccount)));
		Future oilFuture = new Future("OIL.3MNTH", new ISIN("OIL123456"));
		Future goldFuture = new Future("GLD.3MNTH", new ISIN("GLD987654"));
		Future coffeeFuture = new Future("COF.3MNTH", new ISIN("COF24680"));
		Order order1 = new Order(tradingAccount, oilFuture, 1000, 2500);
		Order order2 = new Order(tradingAccount, goldFuture, 200, 4300);
		Order order3 = new Order(tradingAccount, coffeeFuture, 100, 400);
		OrdersDAO orderDAO = null;
		OrderSearchService orderSearchService = new OrderSearchServiceImpl2(orderDAO);
		// when
		List<Order> orders = orderSearchService.getOrders(trader, tradingAccount, coffeeIsinCode);
		// then
		assertThat(orders)
				.containsOnly(order1, order2, order3)
				.doesNotHaveDuplicates();
	}
	
	@Test
	public void getPermissions_GivenNewUser_ThenReturnsNoPermissions() {
		// given
		Trader trader = new Trader();
		// when + then
		assertTrue(trader.getPermissions().isEmpty()); 				// Computer dialect
																	// .
		assertThat(trader.getPermissions().isEmpty(), is(true));	// .
																	// .
		assertThat(trader.getPermissions()).isEmpty();				// .
																	// .
		assertThat(trader).hasNoPermissions();			 			// Human dialect
	}
	
	@Test
	public void methodUnderTest_GivenInputsABC_AndSystemStateDEF_ThenExpectXYZ2() {
		// given
		
		// when
		
		// then
	}

}
