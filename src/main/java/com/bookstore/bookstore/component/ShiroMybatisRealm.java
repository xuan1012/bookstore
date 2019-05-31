package com.bookstore.bookstore.component;

import com.bookstore.bookstore.dao.UserMapper;
import com.bookstore.bookstore.dao.model.User;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class ShiroMybatisRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        return authorizationInfo;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //用户名
        Object principal = token.getPrincipal();
        //密码
//        String credentials = (String)token.getCredentials();
//        log.info("shiro开始登陆 [{},{}] ", principal,credentials);
        List<User> users = userMapper.selectByMap(ImmutableMap.of("username", principal));
        if (users == null || users.isEmpty()) {
            return null;
        }

        //切换为完整的用户信息
        User user = users.get(0);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());

        return info;
    }
}
