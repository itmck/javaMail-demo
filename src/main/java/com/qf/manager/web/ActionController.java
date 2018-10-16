package com.qf.manager.web;

import com.qf.manager.pojo.User;
import com.qf.manager.service.UserService;
import com.qf.manager.utils.MailUtils;
import com.qf.manager.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by it_mck 2018/10/13 23:50
 *
 * @Description: 用于测试登录注册是否能正常使用JavaMail
 * @Version: 1.0
 */
@Controller
@RequestMapping("/log")
public class ActionController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String regist() {

        return "regist";//进入注册页面
    }

    @RequestMapping("/sucess")
    public String sucess() {

        return "sucess";//进入注册页面
    }
    @RequestMapping("/err")
    public String err() {

        return "404";//进入注册页面
    }

    @RequestMapping("/indexLogin")
    public String indexLogin() {

        return "login";//进入登录页面
    }

    /**
     * 点击注册进行用户的注册
     *
     * @param user
     * @return
     */
    @RequestMapping("regist")
    @ResponseBody
    public String postRegist(User user, Map<String, Object> map) {

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

        return "sucess";
    }

    /**
     * 激活用户,根据code将标志字段设置为1
     *
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
    public String login(User user, HttpServletRequest request) {

        HttpSession session = request.getSession();
        try {
            User u = userService.login(user);
            if (u != null) {
                //登录验证成功,经信息存入session域
                session.setAttribute("login_user", u.getUname());
                session.setAttribute("msg", "登录成功");
                session.setMaxInactiveInterval(1 * 60);//设置失效时间 单位时间为s  当1分钟没有活动就会失效session
                return "sucess";
            } else {
                session.setAttribute("msg", "登陆失败...............");
                return "fail";
            }
        } catch (Exception e) {
            session.setAttribute("msg", "登陆失败...............");
            e.printStackTrace();
            return "fail";
        }
    }

}
