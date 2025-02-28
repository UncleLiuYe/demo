package site.liuye.demo.service;

import org.apache.ibatis.annotations.Param;
import site.liuye.demo.domain.Role;
import site.liuye.demo.domain.User;

import java.util.List;

public interface UserService {
    boolean addUser(User user);

    boolean batchAddUsers(@Param("users") List<User> users);

    boolean removeUser(Long id);

    boolean updateUser(User user);

    List<User> listUsers();

    User findByUsername(String username);

    List<Role> findRolesByUserId(Long userId);

    List<User> findUsersByCondition(@Param("username") String username, @Param("email") String email);
}
