package com.qf.manager.utils.checkCode;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Create by it_mck 2018/10/16 16:44
 *
 * @Description:
 * @Version: 1.0
 */
public class VerifyCodeUtil {

    private static final char[] CHARS = {'2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
            'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'} ;

    //随机数
    private static Random random = new Random();

    /**
     * 返回随机数（num是这个随机数的位数）
     * @param num 传入要返回的位数
     * @return
     */
    private static String getRandomString(int num){
        StringBuilder stringBuffer = new StringBuilder();
        for(int i = 0 ; i < num; i ++){
            stringBuffer.append(CHARS[random.nextInt(CHARS.length)]); //nextInt 返回一个随机的int值，
        }
        return stringBuffer.toString();
    }


    /**
     * 获取随机数颜色
     * @return
     */
    private static Color getRandomColor(){
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    /**
     * 返回颜色的反色
     * @param color
     * @return
     */
    private static Color getReverseColor(Color color){
        return new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
    }

    /**
     * 输出一个验证码
     * @param request
     * @param response
     * @throws IOException
     */
    public static void outputCaptch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        String randomString = getRandomString(4);//获取6位随机数
        HttpSession session = request.getSession(true);//getSession(true)若存在会话则返回该会话，否则新建一个会话.设值进入到session中
        session.setAttribute("randomString", randomString); //存入该数据
        session.setMaxInactiveInterval(60 * 3); //值为秒 ，设置该session的存活时间为3分钟，超时验证码失效


        //验证码的长宽
        int width = 100;
        int height = 30;

        Color color = getRandomColor();//获取随机颜色
        Color reverse = getReverseColor(color); //获取反色

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);//等于获得一块画布
        Graphics2D g = bi.createGraphics(); //创建画笔
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16)); //字体设置
        g.setColor(color); //字体颜色
        g.fillRect(0, 0, width, height); //填充矩形
        g.setColor(reverse); //背景色
        g.drawString(randomString, 18, 20);//开始作画

        int n = random.nextInt(100); //是从0到n的随机数

        for (int i = 0; i < n; i ++){
            g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
        }

        //转换成jpeg格式
        ////使用PrintWriter可能会带来一些小的开销，因为它将所有的原始输出都转换为字符流来输出，因此如果使用它来作为页面输出的话，系统要负担一个转换过程。而
        // 使用ServletOutputStream作为页面输出的话就不存在一个问题，但它是以二进制进行输出的.等价于PrintWriter
        ServletOutputStream sos = response.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(sos); //创建图片
        encoder.encode(bi); //将上面数据放入图中

        sos.flush();//刷新
    }

    public static void main(String[] args) {
        String randomString = VerifyCodeUtil.getRandomString(9);
        System.out.println(randomString);
    }
}
