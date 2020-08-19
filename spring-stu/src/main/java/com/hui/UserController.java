package com.hui;

/**
 * @author: Lance
 * @Date: 2020-08-16 11:10
 * @Description:
 */
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
