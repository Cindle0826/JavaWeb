package com.web.controller;import java.io.IOException;import java.io.PrintWriter;import java.util.Date;import javax.servlet.GenericServlet;import javax.servlet.ServletException;import javax.servlet.ServletRequest;import javax.servlet.ServletResponse;public class HelloGenericServlet extends GenericServlet{    /*        controller -> servlet    */    @Override    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {        //request 表示收到 Clint 端的內容 http://localhost:8080/.../...?name=John          String name = req.getParameter("name");                //response 表示要回應給 Client 端的內容                System.out.printf("Hi %s %s\n",name, new Date()); //印在 Server 的Console中 debug用        PrintWriter out = res.getWriter();        out.print("Hi: ");        out.print(name);        out.print(" " + new Date());                    }    }