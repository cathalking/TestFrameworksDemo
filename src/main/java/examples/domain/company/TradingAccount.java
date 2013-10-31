package examples.domain.company;

public class TradingAccount {

	public TradingFirm getTradingFirm() {
		return tradingFirm;
	}

	public void setTradingFirm(TradingFirm tradingFirm) {
		this.tradingFirm = tradingFirm;
	}

	public ClearingFirm getClearingFirm() {
		return clearingFirm;
	}

	public void setClearingFirm(ClearingFirm clearingFirm) {
		this.clearingFirm = clearingFirm;
	}

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

	@Override
	public String toString() {
		return "TradingAccount [tradingFirm=" + tradingFirm + ", clearingFirm=" + clearingFirm + ", status=" + status
				+ "]";
	}
	
}
