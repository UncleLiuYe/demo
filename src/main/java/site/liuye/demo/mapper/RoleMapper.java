package site.liuye.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.liuye.demo.domain.Role;

import java.util.List;

@Mapper
public interface RoleMapper {
    int insertRole(Role role);

    int deleteRole(Long id);

    int updateRole(Role role);

    List<Role> findAll();
}
