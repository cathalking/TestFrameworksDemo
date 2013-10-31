package examples.assertions.custom;

import org.fest.assertions.api.Assertions;

import examples.assertions.custom.TraderAssert;
import examples.domain.user.Trader;

public class ProjectAssertions extends Assertions {
	
	public static TraderAssert assertThat(Trader trader) {
		return new TraderAssert(trader);
	}

}
