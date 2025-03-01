package site.liuye.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import site.liuye.demo.entity.UserRole;

import java.util.List;

@Mapper
public interface UserRoleMapper {
    UserRole getUserRoleById(@Param("id") Long id);

    List<UserRole> listUserRolesByUserId(@Param("userId") Long userId);

    List<UserRole> listUserRolesByRoleId(@Param("roleId") Long roleId);

    int countUserRoles();

    int saveUserRole(UserRole userRole);

    int removeUserRoleById(@Param("id") Long id);

    List<String> listUserRoleDTOsByUserId(@Param("userId") Long userId);
}
