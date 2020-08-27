package com.hui.my;

import org.springframework.stereotype.Controller;

/**
 * @author: Lance
 * @Date: 2020-08-16 11:10
 * @Description:
 */
@Controller
public class UserController {

    @MyAutowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }
}
