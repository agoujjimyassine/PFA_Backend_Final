package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.Role;

public interface RoleServiceI {
	public Role add(Role role);

	public Optional<Role> find(Integer id);

	public Role edit(Role role);

	public void delete(Integer id);

	public List<Role> getAll();
}
