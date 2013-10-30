package examples.domain.company;

public class TradingAccount {

	private TradingFirm tradingFirm;
	private ClearingFirm clearingFirm;
	boolean active;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((clearingFirm == null) ? 0 : clearingFirm.hashCode());
		result = prime * result + ((tradingFirm == null) ? 0 : tradingFirm.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradingAccount other = (TradingAccount) obj;
		if (active != other.active)
			return false;
		if (clearingFirm == null) {
			if (other.clearingFirm != null)
				return false;
		} else if (!clearingFirm.equals(other.clearingFirm))
			return false;
		if (tradingFirm == null) {
			if (other.tradingFirm != null)
				return false;
		} else if (!tradingFirm.equals(other.tradingFirm))
			return false;
		return true;
	}
}
