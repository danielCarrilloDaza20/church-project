package co.edu.uptc.gerencia.dao;

import co.edu.uptc.gerencia.entity.Role;

public interface RoleDao {

    Role findRoleByName(String roleName);
}
