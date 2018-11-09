package com.qf.manager.web;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by it_mck 2018/11/9 9:18
 *
 * @Description:
 * @Version: 1.0
 */
@Controller
@RequestMapping("free")
public class FreeMarkController {

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;//注入 让spring帮我们创建FreeMarkerConfigurer

    /**
     * 生成freemark模板
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    @RequestMapping("ftl")
    @ResponseBody
    public String getFreeMarkHtml() throws IOException, TemplateException {
         //生成静态页面
        //2、从FreeMarkerConfigurer对象中获得Configuration对象。
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        // 3、使用Configuration对象获得Template对象。
        Template template = configuration.getTemplate("hello1.html");//得到模板对象
        Map data = new HashMap<>();
        data.put("hello", "spring freemarker test");
        data.put("url", "www.baidu.com");
        //文件夹不存在是要事先创建,否则报错
        File file = new File("D:/temp");//封装文件夹路径对象
        if(!file.exists()){
            //如果不存在文件夹就创建
            file.mkdirs();
        }
        Writer out = new FileWriter(new File(file,"/test.html"));//创建写出流对象
        template.process(data, out);//输出模板对象
        out.close();
        //返回结果
        return "OK";
    }

    @RequestMapping("/h")
    public String helloFreeMarker(Model model) {
        model.addAttribute("name","ITDragon博客");
        return "hello";
    }
}
