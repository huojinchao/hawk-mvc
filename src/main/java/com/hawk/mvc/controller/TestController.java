package com.hawk.mvc.controller;

import com.hawk.mvc.beans.User;
import com.hawk.mvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: huojc1
 * @createtime: 2019-09-02 22:52
 * <p>------------------------------------------------------------</p>
 * <p> Modification of records</p>
 * <p> Number, date, modifier, reason</p>
 * <p> 1 </p>
 **/
@Controller
//@RequestMapping("/admin")
public class TestController {
    @Resource
    private UserService userService;
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello world!";
    }

    @PostMapping("/hello")
    @ResponseBody
    public String post(String username,String password){
        System.out.println(username+":"+password);
        return "Hello world!";
    }

    @GetMapping("/hi/{name}")
    @ResponseBody
    public String getName(@PathVariable("name") String name ){
        System.out.println("name:"+name);
        return "name:"+name;
    }
    @RequestMapping("/user")
    @ResponseBody
    public User selectUser(){
        User user = new User();
        user.setName("霍锦超");
        user.setAge(20);
        user.setBirthDay(new Date());
        user.setUsername("huojc1");
        user.setPassword("hjc123");
        return user;
    }
    @GetMapping("/user1")
    public ModelAndView findByUsername(String username){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findByUsername(username);
        modelAndView.setViewName("/info");
        modelAndView.addObject("user",user);
        return  modelAndView;
    }
    @GetMapping("/list")
    public ModelAndView selectUserList(){
        ModelAndView modelAndView = new ModelAndView("/userlist");
        List<User> userList = new ArrayList<>();
        for (int i=0;i<100;i++){
            User user = new User();
            user.setName("霍锦超");
            user.setAge(i);
            user.setBirthDay(new Date());
            user.setUsername("admin"+i);
            user.setPassword("hjc123");
            user.setSalary((float) 3000+i*200);
            userList.add(user);
        }
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }
}
