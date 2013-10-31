package examples.test.builders;

import examples.domain.company.AccountStatus;
import examples.domain.company.ClearingFirm;
import examples.domain.company.TradingAccount;
import examples.domain.company.TradingFirm;
import static examples.test.builders.TradingFirmBuilder.*;
import static examples.test.builders.ClearingFirmBuilder.*;

public class TradingAccountBuilder {

	private TradingFirm tradingFirm = aTradingFirm().build();
	private ClearingFirm clearingFirm = aClearingFirm().build();
	private AccountStatus status = AccountStatus.ACTIVE;
	
	private TradingAccountBuilder() { }
	
	public static TradingAccountBuilder aTradingAccount() {
		return new TradingAccountBuilder();
	}
	
	public TradingAccountBuilder withTradingFirm(TradingFirm tradingFirm) {
		this.tradingFirm = tradingFirm;
		return this;
	}
	
	public TradingAccountBuilder with(TradingFirmBuilder tradingFirm) {
		return withTradingFirm(tradingFirm);
	}

	public TradingAccountBuilder withTradingFirm(TradingFirmBuilder tradingFirm) {
		this.tradingFirm = tradingFirm.build();
		return this;
	}
	
	public TradingAccountBuilder withClearingFirm(ClearingFirm clearingFirm) {
		this.clearingFirm = clearingFirm;
		return this;
	}
	
	public TradingAccountBuilder isInActive() {
		this.status = AccountStatus.INACTIVE;
		return this;
	}

	public TradingAccountBuilder withAccountStatus(AccountStatus status) {
		this.status = status;
		return this;
	}
	
	public TradingAccount build() {
		return new TradingAccount(tradingFirm, clearingFirm, status);
	}
	
	public TradingAccountBuilder but() {
		return new TradingAccountBuilder()
					.withTradingFirm(tradingFirm)
					.withClearingFirm(clearingFirm)
					.withAccountStatus(status);
	}
}
