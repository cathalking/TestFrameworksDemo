package examples.test.builders;

import tradingapp.domain.securities.Future;
import tradingapp.domain.securities.ISIN;
import static examples.test.builders.ClearingFirmBuilder.*;
import static examples.test.builders.ISINBuilder.*;

public class FutureBuilder {

	private String desc = "AFUTR";
	private ISIN isin = anISIN().build();
	
	private FutureBuilder() { }
	
	public static FutureBuilder aFuture() {
		return new FutureBuilder();
	}
	
	public FutureBuilder withDesc(String desc) {
		this.desc = desc;
		return this;
	}
	
	public FutureBuilder withIsin(ISIN isin) {
		this.isin = isin;
		return this;
	}
	
	public FutureBuilder with(ISINBuilder isin) {
		return withIsin(isin);
	}

	public FutureBuilder withIsin(ISINBuilder isin) {
		this.isin = isin.build();
		return this;
	}
	
	public Future build() {
		Future future = new Future(desc, isin);
		return future;
	}
	
	public FutureBuilder but() {
		return new FutureBuilder()
						.withDesc(desc)
						.withIsin(isin);
	}
}
