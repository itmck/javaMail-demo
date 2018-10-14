package com.qf.manager.web;

import com.qf.manager.pojo.User;
import com.qf.manager.service.UserService;
import com.qf.manager.utils.MailUtils;
import com.qf.manager.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by it_mck 2018/10/13 23:50
 *
 * @Description:
 * @Version: 1.0
 */
@Controller
@RequestMapping("/log")
public class RegistController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String regist() {

        return "regist";//进入注册页面
    }
    @RequestMapping("/indexLogin")
    public String indexLogin() {

        return "login";//进入注册页面
    }

    /**
     * 点击注册进行用户的注册
     *
     * @param user
     * @return
     */
    @RequestMapping("regist")
    @ResponseBody
    public Map<String, Object> postRegist(User user) {

        Map<String, Object> map = new HashMap<>();
        user.setState(0);//0代表未激活 1代表已经激活
        user.setCode(UUIDUtils.getUUID());

        try {
            int i = userService.registUser(user);
            MailUtils.sendEmail(user.getEmail(), user.getCode());
            map.put("sucess", "注册成功,进入邮箱激活后即可使用");
        } catch (Exception e) {
            map.put("fail", "注册失败,重新注册");
            e.printStackTrace();
        }

        return map;
    }

    /**
     * 激活用户,根据code将标志字段设置为1
     * @param code
     * @return
     */
    @RequestMapping("active")
    @ResponseBody
    public Map<String, Object> activeUser(String code) {

        Map<String, Object> map = new HashMap<>();
        try {
            int i = userService.activeUser(code);
            map.put("sucess", "激活成功,账户可以登录");
        } catch (Exception e) {
            map.put("fail", "激活失败...............");
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("login")
    @ResponseBody
    public Map<String, Object> login(User user) {

        Map<String, Object> map = new HashMap<>();
        try {
            User u = userService.login(user);
            if(u!=null){
                map.put("sucess", "登录成功,账户可以登录");
            }else{
                map.put("fail", "登陆失败...............");
            }
        } catch (Exception e) {
            map.put("fail", "登陆失败...............");
            e.printStackTrace();
        }
        return map;
    }

}
