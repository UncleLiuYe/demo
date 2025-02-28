package site.liuye.demo.service.impl;

import jakarta.annotation.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import site.liuye.demo.domain.Role;
import site.liuye.demo.domain.User;
import site.liuye.demo.mapper.UserMapper;
import site.liuye.demo.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean addUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRegistrationTime(LocalDateTime.now());
        return userMapper.insertUser(user) > 0;
    }

    @Override
    public boolean batchAddUsers(List<User> users) {
        for (User user : users) {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            user.setRegistrationTime(LocalDateTime.now());
        }
        return userMapper.batchInsertUsers(users) > 0;
    }

    @Override
    public boolean removeUser(Long id) {
        return userMapper.deleteUser(id) > 0;
    }

    @Override
    public boolean updateUser(User user) {
        if (!user.getPassword().isBlank()) {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
        }
        return userMapper.updateUser(user) > 0;
    }

    @Override
    public List<User> listUsers() {
        return userMapper.listUsers();
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public List<Role> findRolesByUserId(Long userId) {
        return userMapper.findRolesByUserId(userId);
    }

    @Override
    public List<User> findUsersByCondition(String username, String email) {
        return userMapper.findUsersByCondition(username, email);
    }
}
