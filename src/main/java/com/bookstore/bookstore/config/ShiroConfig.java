package com.bookstore.bookstore.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.bookstore.bookstore.component.ShiroMybatisRealm;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: bookstore
 * @author: xuan
 * @create: 2019-06-10 11:50
 **/
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        //确保静态资源和登录页面可以被访问
        chainDefinition.addPathDefinition("/css/**", "anon");
        chainDefinition.addPathDefinition("/fonts/**", "anon");
        chainDefinition.addPathDefinition("/img/**", "anon");
        chainDefinition.addPathDefinition("/js/**", "anon");
        chainDefinition.addPathDefinition("/style.css", "anon");
        chainDefinition.addPathDefinition("/images/**", "anon");
        chainDefinition.addPathDefinition("/favicon.ioc", "anon");
        chainDefinition.addPathDefinition("/layui/**", "anon");
        chainDefinition.addPathDefinition("/style/**", "anon");
        //一些页面的权限控制
        chainDefinition.addPathDefinition("/user/reg", "anon");
        chainDefinition.addPathDefinition("/user/doReg", "anon");
        chainDefinition.addPathDefinition("/", "anon");
        chainDefinition.addPathDefinition("/user/log", "anon");
        chainDefinition.addPathDefinition("/user/dolog", "anon");
        chainDefinition.addPathDefinition("/book/addToCart", "anon");
        chainDefinition.addPathDefinition("/book/search", "anon");
        chainDefinition.addPathDefinition("/book/findBook", "anon");
        chainDefinition.addPathDefinition("/book/allSearch", "anon");
        chainDefinition.addPathDefinition("/user/doGetBack", "anon");
        chainDefinition.addPathDefinition("/user/getBack", "anon");
        chainDefinition.addPathDefinition("/user/getEmail", "anon");
        chainDefinition.addPathDefinition("/store/query", "anon");
        chainDefinition.addPathDefinition("/user/logout", "logout");
        //TODO 需要继续配置其他页面是可访问的，比如商品详情页等
        //其他页面需要认证后访问

        //TODO 为了开发便利，暂时允许所有访问
        chainDefinition.addPathDefinition("/**", "authc");
//        chainDefinition.addPathDefinition("/**", "anon");

        return chainDefinition;
    }

    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }


    @Bean
    public Realm realm() {
        // uses 'classpath:shiro-users.properties' by default
        ShiroMybatisRealm realm = new ShiroMybatisRealm();
        // Caching isn't needed in this example, but we can still turn it on
        realm.setCachingEnabled(true);
        return realm;
    }


    @Bean("shiroCacheManager")
    public CacheManager cacheManager() {
        // Caching isn't needed in this example, but we will use the MemoryConstrainedCacheManager for this example.
        return new MemoryConstrainedCacheManager();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {

        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setUsePrefix(true);

        return defaultAdvisorAutoProxyCreator;
    }

}