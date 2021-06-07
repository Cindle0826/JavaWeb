package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//  利用@配置Servlet
//  http://localhost:8080/JavaEE_Web/HelloNewServlet
@WebServlet(name = "HelloNewServlet",urlPatterns = {"/HelloNewServlet","/aaa/bbb","/anyword/*"})

public class HelloNewServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("HelloNewServlet " + new Date());
    }
    
}
