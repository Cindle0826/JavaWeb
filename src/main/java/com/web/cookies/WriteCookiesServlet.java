package com.web.cookies;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/controller/cookies/write")
public class WriteCookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String salary = req.getParameter("salary");
        String age = req.getParameter("age");
        
        // Cookies 
        Cookie cookieSalary = new Cookie("Salary", salary + "");
        Cookie cookieAge = new Cookie("Age", age + "");
        
        // 設定續存時間(秒) 預設存30 min
        cookieSalary.setMaxAge(10);
        cookieAge.setMaxAge(10);
        
        //將cookie 寫入 session
        resp.addCookie(cookieSalary);
        resp.addCookie(cookieAge);
        
        resp.getWriter().print("Write cookie ok !");
    }

}
