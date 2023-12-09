package com.team11.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.team11.domain.User;
import com.team11.service.UserService;
import com.team11.util.ReturnResult;
import com.team11.vo.UserVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

@RestController
@CrossOrigin //解决跨域问题
@Api(tags = "UserController")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public HashMap<String,Object> login(@RequestParam String account, @RequestParam String upass, Model model){
        System.out.println("login -- "+account+" -- "+upass);
        HashMap<String,Object> result = new HashMap<>();
        UserVO user = userService.selectOne(account);
        if (user != null && user.getUpass().equals(upass)){
            model.addAttribute("user",user);
            result.put("uid",user.getUid());
            result.put("msg",1);

            StpUtil.login(user.getUid());
            String tokenName = StpUtil.getTokenInfo().getTokenName();
            String tokenValue = StpUtil.getTokenInfo().getTokenValue();
            result.put("tokenName",tokenName); //{tokenName: tokenValue}
            result.put("tokenValue",tokenValue);
        }else {
            result.put("msg",0);
        }
        return result;
    }

//    @PostMapping("login")
//    public ReturnResult login(@RequestParam String account, @RequestParam String upass){
//        System.out.println("login -- "+account+" -- "+upass);
//        UserVO user = userService.selectOne(account);
//        if (user != null && user.getUpass().equals(upass)){
//
//            StpUtil.login(user.getUid());
//            String tokenName = StpUtil.getTokenInfo().getTokenName();
//            String tokenValue = StpUtil.getTokenInfo().getTokenValue();
//            return ReturnResult.createResult(1).setAttr("uid",user.getUid())
//                    .setAttr("tokenName",tokenName)
//                    .setAttr("tokenValue",tokenValue);
//        }else {
//            return ReturnResult.createError(0,"用户名或密码错误");
//        }
//    }

    @PostMapping("register")
    public int register(User user){
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("index.html");
//        User user = new User();
//        user.setUname(username);
//        user.setUpass(password);
        int msg = userService.register(user);
//        mv.addObject("msg",msg);
        return msg;
    }

    @PostMapping("messageUpdate")
    @SaCheckLogin
    public HashMap<String,Object> messageUpdate(User user){
        System.out.println(user.getUid()+"-"+user.getUpass());
        System.out.println("message update");
        HashMap<String,Object> result = new HashMap<>();
        result.put("msg",userService.messageUpdate(user));
        result.put("user",userService.selectOne(user.getUid()));
        return result;
    }

    @RequestMapping("show")
    @SaCheckLogin
    public HashMap<String,Object> show(Integer uid){
        HashMap<String,Object> result = new HashMap<>();
        result.put("user",userService.selectOne(uid));
        result.put("msg",1);
        return result;
    }

    @RequestMapping("exist")
    @SaCheckLogin
    public int exist(int uid){
        StpUtil.logout(uid);
        return 1;
    }

    @Autowired
    JavaMailSender javaMailSender;
    /**
     * 普通邮件发送
     */
    @RequestMapping("sendMail")
    public String sendSimpleMail() {
        // 构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件主题
        message.setSubject("这是一封测试邮件");
        // 设置邮件发送者，这个跟application.yml中设置的要一致
        message.setFrom("1403724251@qq.com");
        // 设置邮件接收者，可以有多个接收者，中间用逗号隔开，以下类似
        // message.setTo("10*****16@qq.com","12****32*qq.com");
        message.setTo("2367569086@qq.com");
//        // 设置邮件抄送人，可以有多个抄送人
//        message.setCc("12****32*qq.com");
//        // 设置隐秘抄送人，可以有多个
//        message.setBcc("7******9@qq.com");
        // 设置邮件发送日期
        message.setSentDate(new Date());
        // 设置邮件的正文
        message.setText("这是team11测试邮件的正文");
        // 发送邮件
        javaMailSender.send(message);
        return "发送成功11";
    }

}
