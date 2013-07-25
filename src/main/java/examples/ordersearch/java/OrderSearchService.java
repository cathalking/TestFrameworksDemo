package examples.ordersearch.java;

import java.util.List;


public interface OrderSearchService {

	List<SearchResults> execute(SearchParams searchParams);
}
