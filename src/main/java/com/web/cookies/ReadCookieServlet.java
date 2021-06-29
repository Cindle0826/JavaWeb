package com.web.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/controller/cookies/read")
public class ReadCookieServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        Cookie[] cookies = req.getCookies();
        PrintWriter out = resp.getWriter();
        if(cookies != null){
            for(Cookie cookie:cookies){
                out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }else{
            out.print(" No cookie");
        }
        
//        resp.getWriter().print("Write cookie ok !");
    }
    
}
