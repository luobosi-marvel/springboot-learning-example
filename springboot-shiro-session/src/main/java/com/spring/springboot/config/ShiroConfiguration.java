package com.spring.springboot.config;

import com.spring.springboot.realm.MyShiroRealm;
import com.spring.springboot.session.RedisSessionDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ShiroConfiguration
 * Shiro 配置
 *
 * Apache Shiro 核心通过 Filter 来实现，就好像 SpringMvc 通过 DispachServlet 来控制一样。
 * 既然是使用 Filter 一般也就能猜到，是通过 URL 规则来进行过滤和权限校验，所以我们需要
 * 定义一系列关于 URL 的规则和访问权限。
 * @author 萝卜丝
 * @since 2017-10-9
 */
@Configuration
public class ShiroConfiguration {


    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;


    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     *
     * 注意：单独一个 ShiroFilterFactoryBean 配置是会报错的，因为在
     * 初始化 ShiroFilterFactoryBean 的时候需要注入：SecurityManager
     *
     *      Filter Chain 定义说明
     *      1. 一个 URL 可以配置多个 Filter， 使用都好分隔
     *      2. 当设置多个过滤器时，全部验证通过，才视为通过
     *      3. 部分过滤器可指定参数，如 perms，roles
     *
     * @return 返回 ShiroFilter 过滤器
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilter.setSecurityManager(securityManager);



        //自定义拦截器
/*        Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
        filtersMap.put("tokenFilter", tokenFilter());
        shiroFilter.setFilters(filtersMap);*/

        // 拦截器
        Map<String, String> filterchainDefinitionMap = new LinkedHashMap<>();
        // 配置退出过滤器，其中的具体的退出代码 Shiro 已经替我们实现了

        //shiroFilter.setSuccessUrl("/index");
        shiroFilter.setLoginUrl("/login");
        filterchainDefinitionMap.put("/logout", "logout");
        shiroFilter.setUnauthorizedUrl("/430");

        // <!-- authc：所有 url 都必须认证通过才可以访问；anon：所有url 都可以匿名访问-->
        filterchainDefinitionMap.put("/index", "anon");
        filterchainDefinitionMap.put("/**", "authc");
        shiroFilter.setFilterChainDefinitionMap(filterchainDefinitionMap);
        return shiroFilter;
    }

    @Bean
    public SecurityManager securityManager() {
        // 使用这个对象报错：The security manager does not implement the WebSecurityManager interface.
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置realm.
        securityManager.setRealm(myShiroRealm());

        // 自定义缓存实现 使用redis
        //securityManager.setCacheManager(cacheManager());
        // 自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    /**
     * 身份认证realm;
     * (这个需要自己写，账号密码校验；权限等)
     * @return 返回身份认证 realm
     */
    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        // 添加凭证匹配器
        //myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    /**
     * 配置shiro redisManager
     * 使用的是shiro-redis开源插件
     * @return
     */
  /*  public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setExpire(1800);// 配置缓存过期时间
        redisManager.setTimeout(timeout);
        // redisManager.setPassword(password);
        return redisManager;
    }*/

    /**
     * cacheManager 缓存 redis实现
     * 使用的是shiro-redis开源插件
     * @return
     */
/*    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }*/

    /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * 使用的是shiro-redis开源插件
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        // redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    /**
     * Session Manager
     * 使用的是shiro-redis开源插件
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        return sessionManager;
    }

    /**
     * 凭证匹配器
     * 由于我们的密码校验交给 Shiro 的 SimpleAuthenticationInfo 进行处理了，
     * 所以我们需要修改下 doGetAuthenticationInfo 中的代码
     * @return 返回凭证匹配器
     */
   /* @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        // 散列算法：这里使用 MD5 算法
        credentialsMatcher.setHashAlgorithmName("md5");
        // 散列的次数，比如散列两次，相当于 md5(md5(""))
        credentialsMatcher.setHashIterations(1);
        return credentialsMatcher;
    }*/

    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     * @param securityManager 权限管理器
     * @return authorizationAttributeSourceAdvisor
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}