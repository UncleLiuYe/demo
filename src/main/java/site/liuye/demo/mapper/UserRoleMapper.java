package site.liuye.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.liuye.demo.domain.UserRole;

@Mapper
public interface UserRoleMapper {
    void insertUserRole(UserRole userRole);

    void deleteUserRolesByUserId(Long userId);

}
