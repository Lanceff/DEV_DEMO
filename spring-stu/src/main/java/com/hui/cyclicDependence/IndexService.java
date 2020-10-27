package com.hui.cyclicDependence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Lance
 * @Date: 2020-09-17 15:27
 * @Description:
 */
@Service
public class IndexService {
    @Autowired
    private UserService userService;
}
