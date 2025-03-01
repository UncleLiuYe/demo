package site.liuye.demo.service;

import site.liuye.demo.entity.UserRole;

import java.util.List;

public interface UserRoleService {
    UserRole getUserRoleById(Long id);

    List<UserRole> listUserRolesByUserId(Long userId);

    List<UserRole> listUserRolesByRoleId(Long roleId);

    int countUserRoles();

    int saveUserRole(UserRole userRole);

    int removeUserRoleById(Long id);

    List<String> listUserRoleDTOsByUserId(Long userId);

}
