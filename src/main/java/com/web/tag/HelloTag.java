package com.web.tag;

import java.io.IOException;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloTag implements Tag {

    /*
        <my:hello />

        晚安現在時刻: ...

        預期
     */
    private PageContext pageContext;
    private Tag parentTag;
    private int hours = new Date().getHours();

    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        // 上層標籤
        parentTag = tag;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            if (hours >= 6 && hours < 12) {
                out.print("早安");
            } else if (hours >= 12 && hours < 18) {
                out.print("午安");
            } else {
                out.print("晚安");
            }
        } catch (IOException ex) {

        }
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print("現在時間: " + new Date().getHours());
        } catch (IOException ex) {

        }
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

    }

}
