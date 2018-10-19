package com.qf.manager.web;

import com.qf.manager.common.BaseController;
import com.qf.manager.common.ResultMessage;
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
public class ActionController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String regist() {

        return "regist";//进入注册页面
    }

    @RequestMapping("/sucess")
    public String sucess() {

        return "sucess";//成功页面
    }

    @RequestMapping("/err")
    public String err() {

        return "404";//错误页面
    }

    @RequestMapping("/indexLogin")
    public String indexLogin() {

        return "login";//进入登录页面
    }
    @RequestMapping("/loginMax")
    public String loginMax() {

        return "max/login_max";//进入登录页面
    }
    @RequestMapping("/registMax")
    public String registMax() {

        return "max/regist_max";//进入登录页面
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
            MailUtils.sendEmail(user.getEmail(), user.getCode());//发送激活邮件到对方邮箱
            map.put("msg", "注册成功,进入邮箱激活后即可使用");
        } catch (Exception e) {
            map.put("msg", "注册失败,重新注册");
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
            map.put("msg", "激活成功,账户可以登录");
        } catch (Exception e) {
            map.put("msg", "激活失败...............");
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("login")
    @ResponseBody
    public ResultMessage login(User user, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String randomString = (String) session.getAttribute("randomString");
        String code = user.getCode();

        if(randomString.equalsIgnoreCase(code)){ //忽略大小写匹配
            try {
                User u = userService.login(user);
                if (u != null) {
                    //登录验证成功,经信息存入session域
                }
                session.setAttribute("login_user", u.getUname());
                session.setAttribute("msg", "登录成功");
                session.setMaxInactiveInterval(1 * 60);//设置失效时间 单位时间为s  当1分钟没有活动就会失效session
                return new ResultMessage(SUCCESS,"登录成功");

            } catch (Exception e) {
                session.setAttribute("msg", "登陆失败...............");
                e.printStackTrace();
                return new ResultMessage(FAIL,"登录失败,用户名或密码错误");
            }
        }else{
            session.setAttribute("msg", "验证码错误...............");
            return new ResultMessage(WRONG_CONST,"登录失败,参数异常");
        }

    }

    /**
     *
     * 异步验证邮箱是否被注册
     * @param email
     * @return
     */
    @RequestMapping(value="/getVerifyEmail")
    @ResponseBody
    public ResultMessage getVerifyEmail(String email){
        try {
            User user = userService.getVerifyEmail(email);
            if(user!=null){
               return new ResultMessage(FAIL,"邮箱已经被占用,请更换邮箱");
            }else{
                return new ResultMessage(SUCCESS,"邮箱已经被占用,请更换邮箱");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMessage(FAIL,"服务器错误");
        }

    }
    /**
     *
     * 异步验证用户名是否被注册
     * @param uname
     * @return
     */
    @RequestMapping(value="/getVerifyUName")
    @ResponseBody
    public Map<String,Object> getVerifyUName(String uname){
        Map<String,Object> map = new HashMap<>();
        try {
            User user = userService.getVerifyUName(uname);
            if(user!=null){
                map.put("msg",1);
            }else{
                map.put("msg",0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;

    }

}
