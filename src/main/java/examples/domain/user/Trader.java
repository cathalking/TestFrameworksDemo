package examples.domain.user;

import java.util.ArrayList;
import java.util.List;

import examples.domain.user.permission.Permission;

public class Trader implements User {

	private String userName;
	private List<Permission> permissions;
	private UserDetail userDetail;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		permissions = new ArrayList<>(permissions);
	}
	
	
}
