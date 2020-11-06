package com.zgy.learn.bootshiro.config;

import com.zgy.learn.bootshiro.pojo.User;
import com.zgy.learn.bootshiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author zuiguangyin
 * @Date 2020/11/5
 * @Description 自定义的realme, 需要继承AuthorizingRealm
 */
@Component // 此处加入Spring管理, 直接创建好了userRealm的bean
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    // 认证，看能不能登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("执行了认证！");
        // 认证封装在了subject.login()之中, 直接在登录的Controller方法之中, 进行认证, 这个套路有点深, 封装了好多层。

        /*
         * // 一个自己处理的例子, 输入root, 123456就正确
         * String username = "root";
         * String password = "123456";
         *
         * // 验证用户名
         * UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
         * if (!usernamePasswordToken.getUsername().equals(username)) {
         *     return null; // UnknownAccountException, 用户名错误
         * }
         *
         * // 验证密码，shiro帮我们做, 不用我们做。 // IncorrectCredentialsException, 密码错误
         * return new SimpleAuthenticationInfo("", password, "");
         *
         *
         */

        // 连接真实的数据库, 用户名验证, 密码验证
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User person = userService.queryUserByName(token.getUsername());
        if (null == person) {
            return null; // 用户验证, 表示没有这个用户
        }

        return new SimpleAuthenticationInfo("", person.getPassword(), ""); // 密码验证
    }


    // 授权, 去操作某一个东西
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("执行了授权！");
        return null;
    }

}
