package com.qf.manager.web;

import com.qf.manager.pojo.Admin;
import com.qf.manager.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create by it_mck 2018/10/21 12:20
 *
 * @Description:
 * @Version: 1.0
 */
@Controller
@RequestMapping(value = "g")
public class GetParamController {


    /**
     * 使用基本类型的包装类好处就是允许传空值.建议使用基本类型的包装类.
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "get1")
    @ResponseBody
    public String getParam(String name,Integer age){

        return name+":"+age;

    }
    @RequestMapping(value = "get2")
    @ResponseBody
    public String getParam2(String[] name){

        StringBuilder stringBuilder = new StringBuilder();
        for(String s:name){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();

    }
    @RequestMapping(value = "get3")
    @ResponseBody
    public String getParam3(User user, Admin admin){


        return user.toString()+" "+admin.toString();

    }

    @InitBinder("user")
    public void initUser(WebDataBinder webDataBinder){

        webDataBinder.setFieldDefaultPrefix("user.");
    }
    @InitBinder("admin")
    public void initAdmin(WebDataBinder webDataBinder){

        webDataBinder.setFieldDefaultPrefix("admin.");
    }



}
