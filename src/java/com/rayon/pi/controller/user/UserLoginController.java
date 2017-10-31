package com.rayon.pi.controller.user;

import com.rayon.framework.PiCache;
import com.rayon.pi.domain.AppConstant;
import com.rayon.pi.domain.BackResult;
import com.rayon.pi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:<br/>
 *
 * @author Rayon
 * @version 0.0.1
 * @date 2017/10/30
 * <p>
 * History:2017/10/30 Rayon 初始创建
 */
@Controller
public class UserLoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="login")
    public String login(HttpServletRequest request, Model model){

        String sessionId = request.getSession().getId();
        model.addAttribute("key",sessionId);
        return "/user/login";
    }

    @RequestMapping(value="ajax/loginexec")
    @ResponseBody
    public BackResult<Object> loginexec(HttpServletRequest request, HttpServletResponse response){

        BackResult<Object> backResult = new BackResult<>();
        String user= request.getParameter("user");
        String pswd = request.getParameter("pswd");

        if(userService.loginexec(user,pswd,request.getSession().getId())) {
            backResult.setCode(AppConstant.LOGIN_SUCCESS.value);
            backResult.setDesc(AppConstant.LOGIN_SUCCESS.desc);
        }else{
            backResult.setCode(AppConstant.LOGIN_FAIL.value);
            backResult.setDesc(AppConstant.LOGIN_FAIL.desc);
        }
        return backResult;
    }

    @RequestMapping(value="index")
    public String indexPage(HttpServletRequest request,Model model){
        return "/user/index";
    }

}
