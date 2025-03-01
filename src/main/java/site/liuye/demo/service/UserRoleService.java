package site.liuye.demo.service;

import site.liuye.demo.entity.UserRole;
import site.liuye.demo.entity.UserRoleDTO;

import java.util.List;

public interface UserRoleService {
    UserRole getUserRoleById(Long id);

    List<UserRole> listUserRolesByUserId(Long userId);

    List<UserRole> listUserRolesByRoleId(Long roleId);

    int countUserRoles();

    int saveUserRole(UserRole userRole);

    int removeUserRoleById(Long id);

    List<UserRoleDTO> listUserRoleDTOsByUserId(Long userId);

}
