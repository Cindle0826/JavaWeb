package com.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet({"/controller/upload/image","/controller/upload/file"})
@WebServlet("/controller/upload/*") //後置路徑對應 * 代表任意字串(path info)
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String path = req.getPathInfo();
        resp.getWriter().print("pathinfo" + path + "<p />");

        switch (path) {
            case "/file":
                uploadFile(req, resp);
                break;
            case "/image":
                uploadimage(req, resp);
                break;
        }
    }

    private void uploadFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void uploadimage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
