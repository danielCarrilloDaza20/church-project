package co.edu.uptc.gerencia.service;

import co.edu.uptc.gerencia.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getRoles();

    Role getById(int id);

    Role getByRoleName(Role role);

    Role createRole(Role role);

    Role updateById(int id, Role role);

    void deleteRole(int id);
}