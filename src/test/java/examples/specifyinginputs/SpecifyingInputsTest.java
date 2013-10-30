package examples.specifyinginputs;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.fest.assertions.api.Assertions.*;
import static examples.assertions.custom.ProjectAssertions.*;

import java.util.Arrays;
import java.util.Iterator;
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
import examples.service.OrderSearchServiceImpl;

public class SpecifyingInputsTest {

//		String coffeeIsinCode = "COF24680";
//		Future coffeeFuture = new Future("COF.3MNTH", new ISIN("COF24680"));
	@Test
	public void getOrders_GivenTraderWithAccountPermissions_SearchingByThatAccountAndIsin_ThenReturnsMatchingOrders() {
		// given - inputs
		Trader trader = new Trader();
		TradingAccount tradingAccount = new TradingAccount();
		trader.setPermissions(Arrays.asList(new Permission(tradingAccount)));
		String goldIsinCode = "COF24680";
		// given - system state
		Future oil3MnthFuture = new Future("OIL.3MNTH", new ISIN("OIL3M0123"));
		Future oil6MnthFuture = new Future("OIL.6MNTH", new ISIN("OIL6M0456"));
		Future goldFuture = new Future("GLD.3MNTH", new ISIN(goldIsinCode));
		String orderId = "ordId";
		Order order1 = new Order(orderId + 1, tradingAccount, oil3MnthFuture, 1000, 2500);
		Order order2 = new Order(orderId + 2, tradingAccount, oil6MnthFuture, 1500, 2600);
		Order order3 = new Order(orderId + 3, tradingAccount, goldFuture, 200, 4300);
		Order order4 = new Order(orderId + 4, tradingAccount, goldFuture, 150, 4300);
		OrdersDAO orderDAO = new OrdersDAOInMemory(order1, order2, order3, order4);
		OrderSearchService orderSearchService = new OrderSearchServiceImpl(orderDAO);
		// when
		List<Order> orders = orderSearchService.getOrders(trader, tradingAccount, goldIsinCode);
		// then
		assertEquals(orders.size(), 2);
		Iterator<Order> itr = orders.iterator();
		assertEquals(itr.next(), order3);
		assertEquals(itr.next(), order4);
		
		assertThat(orders, hasItems(order3, order4));
		assertThat(orders.size(), is(2));

		assertThat(orders).containsOnly(order3, order4);
				
//				.containsSequence(order3, order4);
				
//				.doesNotHaveDuplicates();
	}
	
	@Test
	public void getPermissions_GivenNewUser_ThenReturnsNoPermissions() {
		// given
		Trader trader = new Trader();
		// when + then
		assertThat(trader.getPermissions()).isEmpty();
	}
	
	@Test
	public void getPermissions_GivenNewUser_ThenReturnsNoPermissions2() {
		// given
		Trader trader = new Trader();
		// when + then
		assertTrue(trader.getPermissions().isEmpty());

		assertThat(trader.getPermissions().isEmpty(), is(true));
		
		assertThat(trader.getPermissions()).isEmpty();

		assertThat(trader).hasNoPermissions();
	}
	
	@Test
	public void methodUnderTest_GivenABC_ThenExpectXYZ() {
		// given
		
		// when
		
		// then
	}
	
	@Test
	public void methodUnderTest_GivenInputsABC_AndSystemStateDEF_ThenExpectXYZ2() {
		// given - inputs
		
		// given - system state

		// when
		
		// then
	}

}
