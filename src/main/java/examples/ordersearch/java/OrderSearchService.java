package examples.ordersearch.java;

import java.util.List;

import examples.ordersearch.groovy.SearchParams;

public interface OrderSearchService {

	List<SearchResults> execute(SearchParams searchParams);
}
