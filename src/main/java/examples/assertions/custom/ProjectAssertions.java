package examples.assertions.custom;

import org.fest.assertions.api.Assertions;

import examples.domain.user.Trader;
import examples.domain.user.TraderAssert;

public class ProjectAssertions extends Assertions {
	
	public static TraderAssert assertThat(Trader trader) {
		return new TraderAssert(trader);
	}

}
