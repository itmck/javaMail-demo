package com.qf.manager.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Create by it_mck 2018/10/14 2:28
 *
 * @Description: 发送激活邮件
 * @Version: 1.0
 */
public class MailUtils {

    public static void sendEmail(String to,String code) throws Exception {

        //1创建连接对象,连接到邮箱服务器
        //1、连接邮件服务器的参数配置
        Properties props = new Properties();
        //设置用户的认证方式
        props.setProperty("mail.smtp.auth", "true");
        //设置传输协议
        props.setProperty("mail.transport.protocol", "smtp");
        //设置发件人的SMTP服务器地址
        props.setProperty("mail.smtp.host", "smtp.163.com");
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //javax.mail.AuthenticationFailedException  密码应该填写授权码POP3/SMTP/IMAP
                return new PasswordAuthentication("17355805355@163.com","116719mck");
            }
        });
        //2创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //3设置发件人
        message.setFrom(new InternetAddress("17355805355@163.com"));
        //4设置收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
        //5设置主题
        message.setSubject("激活邮件");
        //6设置正文
        message.setContent("<h1>点击下面链接进行激活</h1><h3><a href='http://localhost:80/ssm/log/active?code="+code+"'>同意授权激活注册</a></h3>","text/html;charset=UTF-8");
        //5发送邮件
        Transport.send(message);
    }
}
