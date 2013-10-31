package examples.domain.company;

public class TradingAccount {

	private TradingFirm tradingFirm;
	private ClearingFirm clearingFirm;
	private AccountStatus status;
	
	public TradingAccount(TradingFirm tradingFirm, ClearingFirm clearingFirm, AccountStatus status) {
		this.tradingFirm = tradingFirm;
		this.clearingFirm = clearingFirm;
		this.status = status;
	}

	public boolean isActive() {
		return status.equals(AccountStatus.ACTIVE);
	}
}
