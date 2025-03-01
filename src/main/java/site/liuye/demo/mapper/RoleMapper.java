package site.liuye.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import site.liuye.demo.entity.Role;

import java.util.List;

@Mapper
public interface RoleMapper {
    Role getRoleById(@Param("id") Long id);

    Role getRoleByName(@Param("name") String name);

    List<Role> listRoles();

    int countRoles();

    int saveRole(Role role);

    int updateRole(Role role);

    int removeRoleById(@Param("id") Long id);
}
