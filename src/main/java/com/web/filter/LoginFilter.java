package com.web.filter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(urlPatterns = {"/secure/*"}) // /secure/*   secure資料夾下的全部攔截
public class LoginFilter extends HttpFilter{
    private static Map<String,String> users = new LinkedHashMap<>();
    static {
        users.put("John", "4321");
        users.put("Mary", "1234");
        users.put("Yun", "8787");
        users.put("admin", "9999");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        /**
         *  chain 往下filter servlet jsp by pass
         */
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean check = false;
        
        /**
         * 如果帳號密碼有在上面的話就可以通過
         * 
         */
        
        /*
            先拆解 在各自拿出 key value
            findAny 有任何一個符合 isPresent 就回傳true
        */
        check =  users.entrySet().stream()
                .filter(e -> e.getKey().equals(username) && e.getValue().equals(password))
                .findAny()
                .isPresent();
        
        if(check){
            chain.doFilter(req, res);
            }else{
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
            if(!(username==null && password==null)){
                req.setAttribute("errorMsg", "登入錯誤");
            }
            rd.forward(req, res);
        }
        
    }
    
}
