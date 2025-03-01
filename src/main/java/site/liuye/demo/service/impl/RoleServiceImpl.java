package site.liuye.demo.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import site.liuye.demo.entity.Role;
import site.liuye.demo.mapper.RoleMapper;
import site.liuye.demo.service.RoleService;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public Role getRoleById(Long id) {
        return roleMapper.getRoleById(id);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleMapper.getRoleByName(name);
    }

    @Override
    public List<Role> listRoles() {
        return roleMapper.listRoles();
    }

    @Override
    public int countRoles() {
        return roleMapper.countRoles();
    }

    @Override
    public int saveRole(Role role) {
        return roleMapper.saveRole(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    @Override
    public int removeRoleById(Long id) {
        return roleMapper.removeRoleById(id);
    }
}
