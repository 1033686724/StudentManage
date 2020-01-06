package com.briup.studentmanage.web.controller;

import com.briup.studentmanage.bean.ex.User;
import com.briup.studentmanage.service.ILoginVerifyService;
import com.briup.studentmanage.util.JwtUtils;
import io.swagger.annotations.Api;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

@RestController
@RequestMapping("/loginController")
@Api(description = "登录")
public class LoginController {
    @Autowired
    ILoginVerifyService iLoginVerifyService;
    @PostMapping("/login")
    public Object login(User user, HttpServletRequest request){
        String token1 = request.getHeader("token");
        if (token1==null||token1.equals(""))
        {
        boolean vf= iLoginVerifyService.verifyUser(user);
        if (vf==true){
            Map<String,Object> map= new HashMap<String, Object>();
            map.put("用户名",user.getUsername());
            map.put("密码",user.getPassword());
            String token=JwtUtils.createToken(map);

            return "登陆成功,token是"+token;
        }else {
            return "密码错误";
        }
    }else{
           if(JwtUtils.verifyToken(token1)==0)
               return "登陆成功";
           else
               return "账户失效，请重新登录";
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
}
