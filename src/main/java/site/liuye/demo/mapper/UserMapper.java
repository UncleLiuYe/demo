package site.liuye.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import site.liuye.demo.domain.Role;
import site.liuye.demo.domain.User;

import java.util.List;

@Mapper
public interface UserMapper {
    int insertUser(User user);

    int batchInsertUsers(@Param("users") List<User> users);

    int deleteUser(Long id);

    int updateUser(User user);

    List<User> listUsers();

    User findByUsername(String username);

    List<Role> findRolesByUserId(Long userId);

    List<User> findUsersByCondition(@Param("username") String username, @Param("email") String email);
}