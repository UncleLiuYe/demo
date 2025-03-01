package site.liuye.demo.service;

import site.liuye.demo.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);

    User getUserByUsername(String username);

    List<User> listUsers();

    int countUsers();

    int saveUser(User user);

    int updateUser(User user);

    int removeUserById(Long id);
}
