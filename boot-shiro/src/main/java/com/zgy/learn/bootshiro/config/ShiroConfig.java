package com.zgy.learn.bootshiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zuiguangyin
 * @Date 2020/11/5
 * @Description ShiroFilterFactoryBean用来拦截相关的请求(A), 需要交给SecurityManager(B)处理, DefaultWebSecurityManager是web上面的
 * shiro功能的总管理者，而具体的配置的情况，需要从我们的自定义的realm(C)之中去获取，所以三个依赖的关系， A--->B--->C的关系。
 */
@Configuration
public class ShiroConfig {

    // 1. 创建realm对象, 一般使用自定义的类, 和最后的方法作用一样, 在UserRealm之中加入了Component, 让spring管理, 此处注入
    @Autowired
    UserRealm userRealm;

    // 3. ShiroFilterFactoryBean
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        // 设置securityManager
        filterFactoryBean.setSecurityManager(securityManager);

        /*
         * anon: 无需认证就可访问
         * authc：必须认证才能访问
         * user：必须拥有记住我功能才能访问
         * perms: 拥有对某个资源的权限才能访问
         * role:拥有某个角色权限才能访问
         */
        // 添加shiro的内置过滤器
        Map<String, String> filterMap = new HashMap<>();
        filterMap.put("/", "anon");
        filterMap.put("/user/*", "authc");
        filterFactoryBean.setFilterChainDefinitionMap(filterMap);

        // 如果认证失败, 跳转到login页面
        filterFactoryBean.setLoginUrl("/login");
        return filterFactoryBean;
    }


    // 2. DefaultWebSecurityManager, 限定为userRealm
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    // 1. 创建realm对象， 一般使用自定义的类
    // @Bean
    // public UserRealm userRealm() {
    //     return new UserRealm();
    // }

}
