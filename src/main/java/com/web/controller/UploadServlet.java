package com.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

//@WebServlet({"/controller/upload/image","/controller/upload/file"})
@WebServlet("/controller/upload/*") //後置路徑對應 * 代表任意字串(path info)
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 30
)
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
        req.getParts()
                .stream()
                .filter(part -> part.getName().equals("cname"))
                .forEach(part -> {
                    try {
                        String cname = IOUtils.toString(part.getInputStream(), StandardCharsets.UTF_8.name());//API apache Apache Commons IO » 2.6
                        resp.getWriter().print(part.getName().toString() + ":");
                        resp.getWriter().print(cname + "<br  / >");
                    } catch (Exception e) {
                    }
                });

        req.getParts()
                .stream()
                .filter(part -> part.getName().equals("upload_file"))
                .forEach(part -> {
                    try {
                        String data = IOUtils.toString(part.getInputStream(), StandardCharsets.UTF_8.name());//API apache Apache Commons IO » 2.6
                        resp.getWriter().print(part.getName().toString() + ":");
                        resp.getWriter().print(data + "<br  / >");
                    } catch (Exception e) {
                    }
                });
    }

    private void uploadimage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParts()
                .stream()
                .filter(part -> part.getName().equals("cname"))
                .forEach(part -> {
                    try {
                        String cname = IOUtils.toString(part.getInputStream(), StandardCharsets.UTF_8.name());//API apache Apache Commons IO » 2.6
                        resp.getWriter().print(part.getName().toString() + ":");
                        resp.getWriter().print(cname + "<br  / >");
                    } catch (Exception e) {
                    }
                });

        req.getParts()
                .stream()
                .filter(part -> part.getName().equals("upload_file"))
                .forEach(part -> {
                    try {
                        //將intputStream -> byte[] -> base 64 String
                        InputStream is = part.getInputStream();
                        byte[] bytes = IOUtils.toByteArray(is);
                        String data = Base64.getEncoder().encodeToString(bytes);
                        resp.getWriter().print(part.getName().toString() + ":");
                        resp.getWriter().print(data + "<br  / >");
                        String img = "<img src ='data:image/png;base64, %s'>";
                        img = String .format(img, data);
                        resp.getWriter().print(img + "<br />");
                        
                        //  存檔資料夾
                        String fileSavingFolder = getServletContext().getRealPath("/upload");
                        //  確認資料夾是否存在
                        File folder = new File(fileSavingFolder);
                        if (!folder.exists()) {
                            folder.mkdir(); //  建立
                        }
                        //  取得檔名
                        String fname =  part.getSubmittedFileName();
                        //  存檔路徑
                        String fileSavingPath = fileSavingFolder + File.separatorChar+fname;
                        //  將檔案寫入到伺服器中
                        part.write(fileSavingPath);
                    } catch (Exception e) {
                    }
                });
    }

}
