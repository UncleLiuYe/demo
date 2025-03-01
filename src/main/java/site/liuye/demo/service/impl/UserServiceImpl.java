package site.liuye.demo.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import site.liuye.demo.entity.LoginResponse;
import site.liuye.demo.entity.User;
import site.liuye.demo.entity.UserRoleDTO;
import site.liuye.demo.mapper.UserMapper;
import site.liuye.demo.mapper.UserRoleMapper;
import site.liuye.demo.service.UserService;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Lazy
    @Resource
    private AuthenticationManager authenticationManager;

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

    @Override
    public LoginResponse login(String username, String password) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            if (authentication != null && authentication.isAuthenticated()) {
                if (authentication.getPrincipal() instanceof UserDetails) {
                    UserRoleDTO userDetails = (UserRoleDTO) authentication.getPrincipal();
                    LoginResponse loginResponse = new LoginResponse();
                    loginResponse.setId(userDetails.getUser().getId());
                    loginResponse.setUsername(userDetails.getUsername());
                    loginResponse.setRoles(userDetails.getRoles());
                    return loginResponse;
                }
            }
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<String> userRoles = userRoleMapper.listUserRoleDTOsByUserId(user.getId());
        return new UserRoleDTO(user, userRoles);
    }
}
