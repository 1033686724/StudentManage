package com.briup.studentmanage.web.controller;

import com.briup.studentmanage.bean.ex.User;
import com.briup.studentmanage.service.ILoginVerifyService;
import com.briup.studentmanage.util.JwtUtils;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/loginController")
@Api(description = "登录")
public class LoginController {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    ILoginVerifyService iLoginVerifyService;


    // 根据IP分不同的令牌桶, 每天自动清理缓存
    private static LoadingCache<String, RateLimiter> caches = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(1, TimeUnit.DAYS)
            .build(new CacheLoader<String, RateLimiter>() {
                @Override
                public RateLimiter load(String key) throws Exception {
                    // 新的IP初始化 (限流每秒3个令牌响应)
                    return RateLimiter.create(3);
                }
            });


    @PostMapping("/login")
    @ApiOperation("登录")
    public Object login(String username,String password, HttpServletRequest request, HttpSession session)throws Exception {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        String token1 = request.getHeader("token");
        String ip =iLoginVerifyService.getIp(request);
        RateLimiter limiter = caches.get(ip);
        if (limiter.tryAcquire()) {
            if (token1==null||token1.equals(""))
            {   if(!iLoginVerifyService.checkLock(session,username)) {
                    return "该账号已被锁定";
            }else {
                boolean vf= iLoginVerifyService.verifyUser(user);
                if (vf==true){
                    Map<String,Object> map= new HashMap<String, Object>();
                    map.put("用户名",username);
                    map.put("密码",password);
                    String token=JwtUtils.createToken(map);

                    return "登陆成功,token是"+token;
                }else {
                    iLoginVerifyService.addFailNum(session,username);
                    return "密码错误";
                }
            }
            }else{
                if(JwtUtils.verifyToken(token1)==0)
                    return "登陆成功";
                else
                    return "账户失效，请重新登录";
            }

        } else {
                return "该ip账户登录次数过多，请稍后再试";
        }
    }



//   // 测试专用
//    @PostMapping("/login")
//    public Object loginTest(User user, String token2){
//        if (token2==null||token2.equals(""))
//        {
//            boolean vf= iLoginVerifyService.verifyUser(user);
//            if (vf==true){
//                Map<String,Object> map= new HashMap<String, Object>();
//                map.put("用户名",user.getUsername());
//                map.put("密码",user.getPassword());
//                String token=JwtUtils.createToken(map);
//
//                return "登陆成功,token是"+token;
//            }else {
//                return "密码错误";
//            }
//        }else{
//            if(JwtUtils.verifyToken(token2)==0)
//                return "登陆成功";
//            else
//                return "账户失效，请重新登录";
//        }
//
//    }
    @PostMapping("/forgetPasswordAddKey")
    @ApiOperation("忘记密码出验证码")
    public String forgetPasswordAddKey(String username,String mail) throws Exception{
        int key=(int)(Math.random()*10000)+500;
        iLoginVerifyService.forgetMailaddKey(username,mail,key);
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        try {
            helper.setFrom("799534625@qq.com");
            helper.setTo(mail);
            helper.setSubject("找回密码");
            helper.setText("由于您不记得密码，所以我们向你的密保邮箱发送了一条消息，包含了验证码"+key);
//            FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
//            helper.addInline("weixin", file);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
          e.printStackTrace();
    }
        return "发送成功";
}
    @GetMapping("/verifyMessage")
    @ApiOperation("验证验证码")
    public String verifyMessage(String mail,int key){
       boolean i= iLoginVerifyService.verifyMessage(mail,key);
       iLoginVerifyService.deleteKey(mail);
       if (i==true)
           return "验证成功，准备修改密码";
       else
           return "验证失败";

    }
    @PutMapping("/changePassword")
    @ApiOperation("修改密码")
    public String changePassword(String username,String password,String password1){
        if (!password.equals(password1))
        {
            return "修改失败，两次密码输入不一致";
        }else {
            iLoginVerifyService.changePassword(username,password);
            return "修改成功";
        }


    }
    @PostMapping("/bindMailBox")
    @ApiOperation("绑定邮箱")
    public String BindMailbox(String mail,String username)throws Exception{
        if (mail.matches("^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$")) {
            int key=(int)(Math.random()*10000)+500;
            MimeMessage mimeMessage=mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            try {
                helper.setFrom("799534625@qq.com");
                helper.setTo(mail);
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

    }
    @GetMapping("/verifyBindMailbox")
    @ApiOperation("验证绑定邮箱的验证码")
    public String verifyBindMailbox(String username,String mail,int key){
        boolean i= iLoginVerifyService.verifyMessage(mail,key);
        iLoginVerifyService.deleteKey(mail);
        if (i==true){
            iLoginVerifyService.bindMail(username,mail);
            return "绑定成功";}
        else
            return "绑定失败";
    }
    @GetMapping("/UnlockByMailbox")
    @ApiOperation("解除用户锁定")
    public String unLockUser(HttpSession session,String username,String mail,int key){
        boolean i= iLoginVerifyService.verifyMessage(mail,key);
        iLoginVerifyService.deleteKey(mail);
        if (i==true){
            iLoginVerifyService.clearFailNum(session, username);
            return "解除成功";}
        else
            return "解除失败";

    }

}
