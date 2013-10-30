package examples.domain.securities;

import examples.specifyinginputs.ISIN;

public class Future implements Product {

	private ISIN isin;
	private String desc;

	public Future(String desc, ISIN isin) {
		this.desc = desc;
		this.isin = isin;
	}

	@Override
	public String getIsin() {
		// TODO Auto-generated method stub
		return null;
	}

}
