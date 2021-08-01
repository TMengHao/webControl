package org.blue.controller;

import org.blue.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Blue
 * @date 2021/7/30
 */
@Controller
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model){
        if(StringUtils.hasLength(user.getName()) && "1234".equals(user.getPassword())){
            //保存登录成功的用户
            session.setAttribute("loginUser",user);
            //重定向防止表单重复提交
            return "redirect:index.html";
        }else{
            model.addAttribute("msg","帐号或密码错误");
            return "login";
        }
    }

    @GetMapping("/index.html")
    public String indexPage(HttpSession session,Model model){
        //Object loginUser = session.getAttribute("loginUser");
        //if(loginUser != null){
        //    return "index";
        //}else{
        //    model.addAttribute("msg","请重新登录");
        //    return "login";
        //}
        return "index";
    }
}
