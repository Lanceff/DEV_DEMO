package com.hui;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Lance
 * @Date: 2020-08-29 14:11
 * @Description:
 */
@Controller
public class controller {

    @RequestMapping("/p1")
    @ResponseBody
    public String p1() {
        return "p1 访问";
    }

    @RequestMapping("/p2")
    @ResponseBody
    public String p2() {
        return "p2 访问";
    }

    @RequestMapping("/success")
    @ResponseBody
    public String success() {
        String username = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal != null && principal instanceof UserDetails) {
            UserDetails info = (UserDetails) principal;
            username = info.getUsername();
        }
        return "login success," + username;
    }
}
