package com.web.filter;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper{
    /**
     *  使用filter 來實現多網頁浮水印
     */
    private  PrintWriter out ;
    private CharArrayWriter bufferWriter;
    public MyResponse(HttpServletResponse response) {
        super(response);
        bufferWriter = new CharArrayWriter();
        out = new PrintWriter(bufferWriter);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return out;
    }
    
    public String getHTMLString(){
        return bufferWriter.toString();
    }
}
