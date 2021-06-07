package com.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/CalcArea") //  url-pattern 
public class CalcAreaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("sorry~~");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String String_r = req.getParameter("r");
        int r = Integer.parseInt(String_r);
        double area = Math.pow(r, 2) * Math.PI;

        resp.getWriter().print(String.format("r: %d area: %.2f", r, area));
    }

}
