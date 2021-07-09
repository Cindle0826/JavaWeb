package com.web.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class BMITag implements Tag {

    /*
        1. <my:bmi h="170" w="60/>

        2. <my:bmi h="170" w="60" result="true">
    OUTPUT:
    1. h="170" w="60 bmi=20.76
    2. h="170" w="60 bmi=20.76 resul="正常" (ex:太瘦,太胖...)
    
     */
    private PageContext pageContext;
    private Tag parentTag;
    private double h;
    private double w;
    private Boolean result = false;

    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        parentTag = tag;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    public void setH(double h) {
        this.h = h;
    }

    public void setW(double w) {
        this.w = w;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.println("身高 " + w + "體重 " + h);
        } catch (IOException ex) {

        }
        return Tag.EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            double bmi = w / Math.pow(h / 100.0, 2);
            out.println(String.format("您的  bmi=%.1f", bmi));
            if (result !=null && result) {
                if (bmi >= 18 && bmi < 24) {
                    out.println("正常");
                } else if (bmi > 24) {
                    out.println("過胖");
                } else {
                    out.println("太瘦");
                }
            }
        } catch (IOException ex) {

        }
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

    }

}
