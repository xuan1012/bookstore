package com.bookstore.bookstore.config;

//@Configuration
public class ShiroConfig {

//    @Bean
//    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
//        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
//        //确保静态资源和登录页面可以被访问
//        chainDefinition.addPathDefinition("/layui/**", "anon");
//        chainDefinition.addPathDefinition("/static/**", "anon");
//        chainDefinition.addPathDefinition("/store/login", "anon");
//        chainDefinition.addPathDefinition("/store/shop", "anon");
//        chainDefinition.addPathDefinition("/store/index", "anon");
//        chainDefinition.addPathDefinition("/", "anon");
//        //其他页面需要认证后访问
//        chainDefinition.addPathDefinition("/**", "authc");
//
//        return chainDefinition;
//    }
//
//
//    @Bean
//    public Realm realm() {
//        // uses 'classpath:shiro-users.properties' by default
//        ShiroMybatisRealm realm = new ShiroMybatisRealm();
//        // Caching isn't needed in this example, but we can still turn it on
//        realm.setCachingEnabled(true);
//        return realm;
//    }
//
//
//    @Bean
//    public CacheManager cacheManager() {
//        // Caching isn't needed in this example, but we will use the MemoryConstrainedCacheManager for this example.
//        return new MemoryConstrainedCacheManager();
//    }
}
