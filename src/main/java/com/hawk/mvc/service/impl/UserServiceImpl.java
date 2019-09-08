package com.hawk.mvc.service.impl;

import com.hawk.mvc.beans.User;
import com.hawk.mvc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description:
 * @author: huojc1
 * @createtime: 2019-09-05 06:33
 * <p>------------------------------------------------------------</p>
 * <p> Modification of records</p>
 * <p> Number, date, modifier, reason</p>
 * <p> 1 </p>
 **/
@Service("userService")
public class UserServiceImpl implements UserService {


    @Override
    public User findByUsername(String username) {
        if(username.equals("admin")){
            User user = new User();
            user.setName("霍锦超");
            user.setAge(20);
            user.setBirthDay(new Date());
            user.setUsername("admin");
            user.setPassword("hjc123");
            user.setSalary((float) 25890.89);
            return user;
        }
        return null;
    }
}
