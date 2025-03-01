package site.liuye.demo.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import site.liuye.demo.entity.UserRole;
import site.liuye.demo.entity.UserRoleDTO;
import site.liuye.demo.mapper.UserRoleMapper;
import site.liuye.demo.service.UserRoleService;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public UserRole getUserRoleById(Long id) {
        return userRoleMapper.getUserRoleById(id);
    }

    @Override
    public List<UserRole> listUserRolesByUserId(Long userId) {
        return userRoleMapper.listUserRolesByUserId(userId);
    }

    @Override
    public List<UserRole> listUserRolesByRoleId(Long roleId) {
        return userRoleMapper.listUserRolesByRoleId(roleId);
    }

    @Override
    public int countUserRoles() {
        return userRoleMapper.countUserRoles();
    }

    @Override
    public int saveUserRole(UserRole userRole) {
        return userRoleMapper.saveUserRole(userRole);
    }

    @Override
    public int removeUserRoleById(Long id) {
        return userRoleMapper.removeUserRoleById(id);
    }

    @Override
    public List<UserRoleDTO> listUserRoleDTOsByUserId(Long userId) {
        return userRoleMapper.listUserRoleDTOsByUserId(userId);
    }
}
