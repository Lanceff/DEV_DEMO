package com.hui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author: Lance
 * @Date: 2020-08-29 14:23
 * @Description:
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username=" + username);
        UserDetails userDetails = User.withUsername(username)
                .password("$2a$10$LE09CQDjuBQU.lAthQlQLOQbJRY28cYYnEXlfam8.F5F/jCbu6RgC")
                .authorities("p1").build();
        return userDetails;
    }
}
