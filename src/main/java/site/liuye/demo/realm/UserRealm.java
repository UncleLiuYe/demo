package site.liuye.demo.realm;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.lang.util.ByteSource;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return new SimpleAuthorizationInfo();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        if (!"admin".equals(upToken.getUsername())) {
            throw new UnknownAccountException("用户名错误");
        }
        log.info("Password: {}", new String(upToken.getPassword()));
        return new SimpleAuthenticationInfo(upToken.getUsername(), upToken.getPassword(), ByteSource.Util.bytes(upToken.getUsername()), getName());
    }
}
