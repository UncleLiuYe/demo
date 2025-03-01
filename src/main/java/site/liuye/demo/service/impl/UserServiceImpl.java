package site.liuye.demo.service.impl;

import jakarta.annotation.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import site.liuye.demo.entity.User;
import site.liuye.demo.mapper.UserMapper;
import site.liuye.demo.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public List<User> listUsers() {
        return userMapper.listUsers();
    }

    @Override
    public int countUsers() {
        return userMapper.countUsers();
    }

    @Override
    public int saveUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userMapper.saveUser(user);
    }

    @Override
    public int updateUser(User user) {
        if (StringUtils.hasText(user.getPassword())) {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
        }
        return userMapper.updateUser(user);
    }

    @Override
    public int removeUserById(Long id) {
        return userMapper.removeUserById(id);
    }
}
