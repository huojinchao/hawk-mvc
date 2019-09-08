package com.hawk.mvc.controller;

import com.hawk.mvc.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: huojc1
 * @createtime: 2019-09-03 22:05
 * <p>------------------------------------------------------------</p>
 * <p> Modification of records</p>
 * <p> Number, date, modifier, reason</p>
 * <p> 1 </p>
 **/
@Controller
public class RegisterController {
    @RequestMapping(value = "/register_user",method = RequestMethod.POST)
    @ResponseBody
    public String register1(String username,String password,String name,Integer age,Float salary){
        System.out.println(username+"  "+password+"  "+name+" "+age+" "+salary);
        return "regiseter success";

    }

    @PostMapping("/register_user1")
    @ResponseBody
    public String register2(User user){
        System.out.println(user);
        return "处理成功";

    }
}
