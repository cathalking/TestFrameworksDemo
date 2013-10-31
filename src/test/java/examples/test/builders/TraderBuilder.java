package examples.test.builders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import examples.domain.permission.Permission;
import examples.domain.permission.Restriction;
import examples.domain.user.Trader;
import examples.domain.user.UserDetail;
import static examples.test.builders.UserDetailBuilder.*;

public class TraderBuilder {
	private String userName = "trader1";;
	private UserDetail userDetail = aUserDetail().build();
	private List<Permission> permissions = Collections.emptyList();
	private List<Restriction> restrictions = Collections.emptyList();
	
	private TraderBuilder() { }
	
	public static TraderBuilder aTrader() {
		return new TraderBuilder();
	}
	
	public Trader build() {
		Trader trader = new Trader();
		trader.setUserName(userName);
		trader.setUserDetail(userDetail);
		trader.setPermissions(permissions);
		trader.setRestrictions(restrictions);
		return trader;
	}
	
	public TraderBuilder withUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public TraderBuilder withUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
		return this;
	}
	
	public TraderBuilder withPermissions(List<Permission> permissions) {
		this.permissions = new ArrayList<>(permissions);
		return this;
	}
	
	public TraderBuilder with(PermissionBuilder permission) {
		return withPermissions(permission);
	}
	
	public TraderBuilder withNoPermissions() {
		this.permissions = Collections.emptyList();
		return this;
	}

	public TraderBuilder withPermissions(PermissionBuilder permission) {
		this.permissions = new ArrayList<>(Arrays.asList(permission.build()));
		return this;
	}
	
	public TraderBuilder withRestrictions(List<Restriction> restrictions) {
		this.restrictions = new ArrayList<>(restrictions);
		return this;
	}
	
	public TraderBuilder but() {
		return new TraderBuilder()
						.withUserName(userName)
						.withUserDetail(userDetail)
						.withPermissions(permissions)
						.withRestrictions(restrictions);
	}
}
