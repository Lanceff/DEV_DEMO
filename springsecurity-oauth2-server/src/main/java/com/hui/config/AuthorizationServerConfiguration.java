package com.hui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * @author: Lance
 * @Date: 2020-08-31 08:40
 * @Description:
 */
@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    /**
     * client客户端的信息配置，client信息包括：clientId、secret、scope、authorizedGrantTypes(授权类型)、authorities(授予client的权限)
     * （1）scope：表示权限范围，可选项，用户授权页面时进行选择
     * （2）authorizedGrantTypes：有四种授权方式
     * （3）authorities：授予client的权限(这里的具体实现有多种，in-memory、JdbcClientDetailsService、jwt等)。
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        /*clients.inMemory()
                // client_id
                .withClient("client1")
                // client_secret
                .secret(passwordEncoder.encode("secret"))
                // 授权类型
                .authorizedGrantTypes("authorization_code")
                // 授权范围
                .scopes("app1")
                // 注册回调地址
                .redirectUris("http://www.baidu.com")
                .and()
                .withClient("client2")
                .secret(passwordEncoder.encode("secret"))
                .authorizedGrantTypes("authorization_code")
                .scopes("app2")
                .redirectUris("http://www.baidu.com");*/
        clients.withClientDetails(new JdbcClientDetailsService(dataSource));
    }


    /**
     * AuthorizationServerEndpointsConfigurer：声明授权和token的端点以及token的服务的一些配置信息，比如采用什么存储方式、token的有效期等
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //token 存数据库
        endpoints.tokenStore(new JdbcTokenStore(dataSource));
    }

    /**
     * AuthorizationServerSecurityConfigurer: 声明安全约束，哪些允许访问，哪些不允许访问
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

}
