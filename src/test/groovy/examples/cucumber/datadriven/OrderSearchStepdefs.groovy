package examples.cucumber.datadriven

import cucumber.api.DataTable
import examples.ordersearch.groovy.*
this.metaClass.mixin(cucumber.api.groovy.EN)

List<SearchParams> searchParamsList
List<SearchResults> searchResultsList
OrderSearchService orderSearchService = new OrderSearchService()

Given(~'^I provide following search criteria$') { DataTable arg1 ->
    searchParamsList = arg1.asList(SearchParams.class)
}

When(~'^I run the search$') { ->
    searchResultsList = searchParamsList.collect { SearchParams searchParams ->
		orderSearchService.execute(searchParams) 
		}
}

Then(~'^I should see the following search results$') { DataTable arg1 ->
	def actual = searchResultsList.collect {
		["Account":it.account, "FirmCode":it.firmCode, "Session":it.session, "Contract":it.contract,
		 "BrokerCode":it.brokerCode, "ClientOrdId":it.clientOrderId, "TradeDate":it.tradeDate,
		 "OrderQty":it.orderQty, "RmgQty":it.rmgQty, "OrderPrice":it.orderPrice,
		 "Exchange":it.exchange, "Status":it.status, "Type":it.type]
	}		
	arg1.diff(actual)
}

def Map toMap(object) {
	return object?.properties.findAll{ (it.key != 'class') }.collectEntries {
				it.value == null || it.value instanceof Serializable ? [it.key, it.value] : [it.key,   toMap(it.value)]
		}
	}
