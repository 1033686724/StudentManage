package com.briup.studentmanage.service.impl;

import com.briup.studentmanage.bean.Manager;
import com.briup.studentmanage.bean.ex.User;
import com.briup.studentmanage.mapper.ex.UserLoginMapper;
import com.briup.studentmanage.service.ILoginVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;

@Service
public class LoginVerifyService implements ILoginVerifyService {
    @Autowired
    UserLoginMapper userLoginMapper;


    /*
    *验证是否为数据库中的用户
 */
    @Override
    public boolean verifyUser(User user) throws RuntimeException {
        String username=user.getUsername();
        String password=user.getPassword();
        if (username==null||"".equals(username))
            throw new RuntimeException("用户名为空");
        else {
         if (userLoginMapper.verifyUserName(username).getUsername()==null)
             throw new RuntimeException("用户名不存在");
         else if (password==null||"".equals(password))
            throw new RuntimeException("密码为空");
        else {
            String ps =  userLoginMapper.verifyUser(username).getPassword();
            if (password.equals(ps))
                return true;
            else
                return false;
        }
        }

    }

    /*
     *忘记密码，并且添加key值
     */
    @Override
    public void forgetMailaddKey(String username,String mail, int key) throws RuntimeException {
        if (userLoginMapper.verifyUser(username)==null||userLoginMapper.verifyUser(username).equals(""))
            throw new RuntimeException("用户不存在");
        else {
            String s = userLoginMapper.verifyMail(username).getMail();
            if (s == null || s.equals(""))
                throw new RuntimeException("密保邮箱未绑定");
            else if (!s.equals(mail))
                throw new RuntimeException("密保邮箱错误");
            else {
                userLoginMapper.addKey(key,mail);
            }

        }
    }
    /*
     *验证邮箱验证码
     */

    @Override
    public boolean verifyMessage(String mail, int key) throws RuntimeException {
        int key1=userLoginMapper.findkey(mail).getKey();
        return key==key1;
    }


    /*
     *验证完成后删除数据库验证码
     */
    @Override
    public void deleteKey(String mail) throws RuntimeException {
        userLoginMapper.deletekey(mail);
    }

    /*
     *修改密码
     */
    @Override
    public void changePassword(String username, String password) throws RuntimeException {
        if (userLoginMapper.verifyUser(username)==null||userLoginMapper.verifyUser(username).equals(""))
            throw new RuntimeException("用户不存在");
        else
            userLoginMapper.updatePassword(password,username);
    }

    /*
     *绑定邮箱
     */
    @Override
    public void bindMail(String username, String mail) throws RuntimeException {

            userLoginMapper.updateMail(mail,username);
    }
    /*
     *从HTTP头部 获取用户的ip
     */
    @Override
    public  String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.indexOf(",") != -1) {
            String[] ips = ip.split(",");
            ip = ips[0].trim();
        }
        return ip;
    }

    @Override
    public void addFailNum(HttpSession session, String username) throws RuntimeException {
        Object o = session.getServletContext().getAttribute(username);
        HashMap<String,Object> map=null;
        int num=0;
        if (o==null){
            map=new HashMap<String, Object>();
        }else {
            map= (HashMap<String, Object>) o;
            num= (int) map.get("num");
            Date date= (Date) map.get("lastDate");
            long timeDifference = ((new Date().getTime()-date.getTime())/60/1000);
            if(timeDifference>=30) {
                 num=0;
            }
        }
            map.put("num",num+1);
            map.put("lastDate",new Date());
            session.getServletContext().setAttribute(username,map);


    }

    @Override
    public boolean checkLock(HttpSession session, String username) throws RuntimeException {
        Object o = session.getServletContext().getAttribute(username);
        if(o==null) {
            return true;
        }
        HashMap<String,Object> map  = (HashMap<String, Object>) o;
        int num  = (int) map.get("num");
        Date date = (Date) map.get("lastDate");
        long timeDifference = ((new Date().getTime()-date.getTime())/60/1000);
        if(num>=3&&timeDifference<30) {
            return false;
        }
        return true;

    }

    @Override
    public void clearFailNum(HttpSession session, String username) throws RuntimeException {
            session.getServletContext().removeAttribute(username);
    }
}
