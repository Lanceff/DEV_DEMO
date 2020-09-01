package com.hui.config;

import com.hui.service.impl.SysUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @author: Lance
 * @Date: 2020-08-31 08:40
 * @Description:
 */
@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private SysUserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    @Autowired
    private ClientDetailsService clientDetailsService;
    @Resource(name = "jwtTokenStore")
    private TokenStore tokenStore;
    @Autowired
    private JwtAccessTokenConverter accessTokenConverter;

    @Bean("myClientDetailsService")
    public ClientDetailsService clientDetailsService() {
        ClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        ((JdbcClientDetailsService) clientDetailsService).setPasswordEncoder(passwordEncoder);
        return clientDetailsService;
    }

    /**
     * 设置授权码模式的授权码如何存取，
     */
    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        // return new InMemoryAuthorizationCodeServices(); //内存方式
        return new JdbcAuthorizationCodeServices(dataSource); //数据库模式
    }

    /**
     * 配置令牌服务
     */
    @Bean
    public AuthorizationServerTokenServices tokenService() {
        DefaultTokenServices service = new DefaultTokenServices();
        service.setClientDetailsService(clientDetailsService());
        service.setTokenStore(tokenStore);//
        service.setSupportRefreshToken(true);// 是否支持刷新
        service.setAccessTokenValiditySeconds(7200);//令牌默认有效期2小时
        service.setRefreshTokenValiditySeconds(259200);//刷新令牌默认有效期3天

        //jwt需要添加TokenEnhancerChain
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter));
        service.setTokenEnhancer(tokenEnhancerChain);
        return service;
    }

    /**
     * 用来配置客户端详情服务，客户端详情信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
     * client信息包括：clientId、secret、scope、authorizedGrantTypes(授权类型)、authorities(授予client的权限)
     * 1.clientId ：（必须的）用来标识客户的Id。
     * 2.secret ：（需要值得信任的客户端）客户端安全码，如果有的话。
     * 3.scope：表示权限范围，可选项，用户授权页面时进行选择
     * 4.authorizedGrantTypes：有四种授权方式
     * 5.authorities：授予client的权限(这里的具体实现有多种，in-memory、JdbcClientDetailsService、jwt等)。
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
       /* clients.inMemory()
                .withClient("client1")   //client_id
                .secret(passwordEncoder.encode("secret"))// client_secret
                .resourceIds("res1")
                // 授权类型
                .authorizedGrantTypes("authorization_code", "password", "client_credentials", "implicit", "refresh_token")
                .scopes("all")// 授权范围（标识）
                .autoApprove(false)
                .redirectUris("http://www.baidu.com");// 注册回调地址*/
        clients.withClientDetails(clientDetailsService());
    }

    /**
     * 用来配置令牌（token）的访问端点 和 令牌服务(tokenservices)
     * 声明授权和token的端点以及token的服务的一些配置信息，比如采用什么存储方式、token的有效期等
     * 1.authenticationManager:认证管理器，当你选择了 密码（password）授权类型时，请设置这个属性注入一个 AuthenticationManager对象
     * 2.authorizationCodeServices ：这个属性是用来设置授权码服务的（即 AuthorizationCodeServices 的实例对象），
     * 主要用于 "authorization_code" 授权码类型模式。
     * 3.implicitGrantService ：这个属性用于设置隐式授权模式，用来管理隐式授权模式的状态
     * 4.tokenGranter ：当你设置了这个东西（即 TokenGranter 接口实现），那么授权将会交由你来完全掌控，并且会忽略掉上面的这几个属性，
     * 这个属性一般是用作拓展用途的，即标准的四种授权模式已经满足不了你的需求的时候，才会考虑使用这个
     * 5.userDetailsService ：当你设置了这个之后，那么 "refresh_token" 即刷新令牌授权类型模式的流程中就会包含一个检查，
     * 用来确保这个账号是否仍然有效
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .tokenServices(tokenService())
                .authorizationCodeServices(authorizationCodeServices())
                .userDetailsService(userDetailsService) //用于刷新临牌
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }

    /**
     * 用来配置令牌端点的安全约束，哪些允许访问，哪些不允许访问
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .allowFormAuthenticationForClients()  // 允许客户表单认证,不加的话/oauth/token无法访问
                // 对于CheckEndpoint控制器[框架自带的校验]的/oauth/token端点允许所有客户端发送器请求而不会被Spring-security拦截
                .tokenKeyAccess("permitAll()")//    开启/oauth/token_key验证端口无权限访问
                // 要访问/oauth/check_token必须设置为permitAll()，但这样所有人都可以访问了，设为isAuthenticated()又导致访问不了，这个问题暂时没找到解决方案
                .checkTokenAccess("permitAll()");// 开启/oauth/check_token验证端口认证权限访问
    }

}
