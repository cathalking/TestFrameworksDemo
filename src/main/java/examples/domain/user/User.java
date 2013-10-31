package examples.domain.user;

import java.util.List;

import examples.domain.permission.Permission;

public interface User {

	public String getUserName();

	public List<Permission> getPermissions();

}