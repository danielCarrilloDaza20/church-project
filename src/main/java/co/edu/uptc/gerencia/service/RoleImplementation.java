package co.edu.uptc.gerencia.service;

import co.edu.uptc.gerencia.model.Role;

import java.util.List;

public class RoleImplementation implements RoleService {
    @Override
    public List<Role> getRoles() {
        return List.of();
    }

    @Override
    public Role getById(int id) {
        return null;
    }

    @Override
    public Role getByRoleName(Role role) {
        return null;
    }

    @Override
    public Role createRole(Role role) {
        return null;
    }

    @Override
    public Role updateById(int id, Role role) {
        return null;
    }

    @Override
    public void deleteRole(int id) {

    }
}
