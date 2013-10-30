package examples.domain.user;

import java.util.List;

import examples.domain.user.permission.Permission;

public interface User {

	public String getUserName();

	public List<Permission> getPermissions();

}