package com.rayon.framework;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Description:<br/>
 *
 * @author Rayon
 * @version 0.0.1
 * @date 2017/10/30
 * <p>
 * History:2017/10/30 Rayon 初始创建
 */
public class LoginIntercepter extends HandlerInterceptorAdapter{
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String requestURI = request.getRequestURI().replace(request.getContextPath(), "");
        if(requestURI.startsWith("/login")) {
            return true;
        }else{
            //检验登录有效性
            String sessionId = request.getSession().getId();
            String name = PiCache.sessionToName.get(sessionId);
            if(name != null && PiCache.nameToSession.get(name).equals(sessionId)){
                return true;
            }
        }
        request.getRequestDispatcher("/login").forward(request,response);
        return false;
    }

    /**
     * This implementation is empty.
     * 完成具体方法之后调用
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
    }

    /**
     * This implementation is empty.
     * 完成对页面的render以后调用，之后返回并展现页面
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
    }

    /**
     * This implementation is empty.
     */
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
    }
}
