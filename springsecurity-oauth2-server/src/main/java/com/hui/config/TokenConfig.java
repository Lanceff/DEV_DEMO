package com.hui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author: Lance
 * @Date: 2020-08-31 21:50
 * @Description:
 */
@Configuration
public class TokenConfig {

    private String SIGNING_KEY = "uaa";

    /*@Resource
    private DataSource dataSource;

    @Bean("memoryTokenStock")
    public TokenStore memorytokenStore() {
        return new InMemoryTokenStore();
    }

    @Bean("jdbcTokenStore")
    public TokenStore jdbcTokenStore() {
        return new JdbcTokenStore(dataSource);
    }*/

    @Bean("jwtTokenStore")
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }
}
