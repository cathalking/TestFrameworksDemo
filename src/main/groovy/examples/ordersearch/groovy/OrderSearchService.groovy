package examples.ordersearch.groovy

class OrderSearchService {

	SearchResults execute(SearchParams searchParams) {
		new SearchResults(account:"anAccount", firmCode:"aFirm", session: "aSession", 
			contract:"ABC", brokerCode:"aBroker", clientOrderId:"clOrd123", 
			tradeDate:"20130622", orderQty:123, rmgQty:27, orderPrice:1.8, 
			exchange:"CMEL", status:"Working", type:"Market");
	}
}
