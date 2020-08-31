package com.hui.pojo;

import lombok.Data;

/**
 * @author: Lance
 * @Date: 2020-08-29 15:33
 * @Description:
 */

@Data
public class User {

    private Integer id;
    private String username;
    private String password;
    private String fullName;
    private String mobile;
}