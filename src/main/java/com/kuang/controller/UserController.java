package com.kuang.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kuang.pojo.User;
import com.kuang.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class UserController {
    private static JsonUtils jsonUtils=new JsonUtils();

    @RequestMapping("/json1")
//   思考问题，我们正常返回他会走视图解析器，而json需要返回的是一个字符串;
//   市面上有很多的第三方jar包可以实现这个功能，jackson.只需要一个简单的注解就可以实现了
//   @ResponseBody:将服务器端返回的对象转换为json对象响应回去
    @ResponseBody
    public String json1() throws JsonProcessingException {
//      需要一个jackson的对象映射器，就是一个类，使用它可以直接将对象转换为json字符串
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("eizo", 30, "男");
        System.out.println("user = " + user);
        String str = mapper.writeValueAsString(user);
        System.out.println("str = " + str);

        return str;//由于使用了@ResponseBody注解，这里会将str以json格式的字符串返回，十分方便

    }

    @RequestMapping(value = "/json2", produces = "application/json;charset=utf-8")
// 解决乱码问题：通过@RequestMaping 的produces属性设置来实现编码格式为utf-8，以及它返回的类型
// produces：指定响应体返回类型和编码
    @ResponseBody
    public String json2() throws JsonProcessingException {
        User user = new User("eizo", 30, "男");
        return new ObjectMapper().writeValueAsString(user);//由于使用了@ResponseBody注解，这里会将str以json格式的字符串返回，十分方便

    }

    @RequestMapping(value = "/json3")
    @ResponseBody
    public String json3() throws JsonProcessingException {

        ArrayList<User> list = new ArrayList<>();

        list.add(new User("eizo", 30, "男"));
        list.add(new User("eio", 30, "男"));
        list.add(new User("ezo", 30, "男"));
        list.add(new User("izo", 30, "男"));


        return new ObjectMapper().writeValueAsString(list);

    }

    @RequestMapping(value = "/time1")
    @ResponseBody
    public String json4() throws JsonProcessingException {

        return jsonUtils.timeFormat(new Date());

    }
}
