package site.liuye.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import site.liuye.demo.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUserById(@Param("id") Long id);

    User getUserByUsername(@Param("username") String username);

    List<User> listUsers();

    int countUsers();

    int saveUser(User user);

    int updateUser(User user);

    int removeUserById(@Param("id") Long id);
}