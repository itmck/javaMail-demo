package com.qf.manager.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create by it_mck 2018/10/23 21:36
 *
 * @Description:
 * @Version: 1.0
 */
@Controller
@RequestMapping("xx")
public class LayUIController {


    @RequestMapping("layui")
    public String getLayUI(Model model){
        model.addAttribute("name","mck");
        model.addAttribute("password","123456");
        return "layui";
    }
    @RequestMapping("get")
    public String get(String s,Model model){
        model.addAttribute("s","我是s=="+s);
        System.out.println("s:"+s);
        return "layui";
    }
    @RequestMapping("getV")
    public String getV(String s,Model model){
        model.addAttribute("sv","我是sv=="+s);
        System.out.println("sv:"+s);
        return "layui";
    }
}
