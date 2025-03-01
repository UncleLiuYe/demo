package site.liuye.demo.service;

import site.liuye.demo.entity.Role;

import java.util.List;

public interface RoleService {
    Role getRoleById(Long id);

    Role getRoleByName(String name);

    List<Role> listRoles();

    int countRoles();

    int saveRole(Role role);

    int updateRole(Role role);

    int removeRoleById(Long id);
}
