package com.hui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hui.entity.TbUser;
import com.hui.service.TbPermissionService;
import com.hui.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Lance
 * @Date: 2020-08-31 11:23
 * @Description:
 */
@Service
public class SysUserDetailsService implements UserDetailsService {

    @Autowired
    private TbPermissionService tbPermissionService;
    @Autowired
    private TbUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TbUser::getUsername, username);
        TbUser tuser = userService.getOne(queryWrapper);
        //权限列表
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (tuser != null) {
            //查询用户拥有的权限，后续封装构造UserDetails
            List<String> permissions = tbPermissionService.selectPermissionByUserId(tuser.getId());
            permissions.forEach(permission -> {
                grantedAuthorities.add(new SimpleGrantedAuthority(permission));
            });
        }
        User user = new User(tuser.getUsername(), tuser.getPassword(), grantedAuthorities);
        return user;
    }
}
