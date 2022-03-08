package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

    //    第一种方式：服务器要返回一个字符串，直接使用response
    @RequestMapping("/a1")
    public void ajax(String name, HttpServletResponse response) throws IOException {
        if ("admin".equals(name)) {
            response.getWriter().println("true");
        } else {
            response.getWriter().println("false");
        }
    }

    @RequestMapping("/a2")
    @ResponseBody
    public List<User> ajax2() {
        List<User> list = new ArrayList<>();

        list.add(new User("eizo", 30, "男"));
        list.add(new User("eio", 30, "男"));
        list.add(new User("ezo", 30, "男"));
        list.add(new User("izo", 30, "男"));

        return list;

    }

    @RequestMapping("/a3")
    @ResponseBody
    public String ajax3(String name, String pwd) {
        String msg="";
        if (name!=null){
            if ("admin".equals(name)){
                msg="ok";
            }else {
                msg="用户名有误";
            }
        }
        if (pwd!=null){
            if ("123456".equals(pwd)){
                msg="ok";
            }else {
                msg="密码输入有误";
            }
        }
        return msg;
    }
}
