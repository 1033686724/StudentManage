package com.briup.studentmanage.web.controller;

import com.briup.studentmanage.bean.ex.User;
import com.briup.studentmanage.service.IRegisterService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping("/Register")
@Api(description = "注册")
public class RegisterController {
    @Autowired
    private IRegisterService iRegisterService;
    @Autowired
    private JavaMailSender mailSender;
   @PostMapping("/register")
    public String register(User user) throws Exception{
        String username=user.getUsername();
        // 如果数据库中没有该用户，可以注册，否则跳转页面
        if (iRegisterService.findByUserName(username) == null) {
            // 添加用户
            if (user.getMail().matches("^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$")){
                int key=(int)(Math.random()*10000)+500;
                MimeMessage mimeMessage=mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                iRegisterService.register(user);
                try {
                    helper.setFrom("2594791683@qq.com");
                    helper.setTo(user.getMail());
                    helper.setSubject("绑定邮箱");
                    helper.setText("为了绑定邮箱，所以我们向你所想绑定邮箱发送了一条消息，包含了验证码"+key);
//            FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
//            helper.addInline("weixin", file);
                    mailSender.send(mimeMessage);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                return "发送成功";
            } else {
                return "邮箱格式不正确";
            }

        }else {
            // 注册失败跳转到错误页面
            return "error";
        }

    }

}
