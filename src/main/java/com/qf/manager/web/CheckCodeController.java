package com.qf.manager.web;

import com.qf.manager.utils.checkCode.VerifyCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create by it_mck 2018/10/16 17:03
 *
 * @Description:
 * @Version: 1.0
 */
@Controller
@RequestMapping("/user")
public class CheckCodeController {

    @RequestMapping(value="/getVerifyCode",method = RequestMethod.GET)
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response){
        try {
            VerifyCodeUtil.outputCaptch(request, response);

        } catch (IOException e) {
            System.out.println("验证码获取失败");
            e.printStackTrace();
        }
    }

}
