package com.web.tag;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class WelcomeTag implements Tag {

    /*
        <my:welcome username="john">

        </my:welcome>
    OUTPUT:
    歡迎John 的光臨
    現在時刻:2021/07/09 18:46:25
    
     */
    private PageContext pageContext;
    private Tag parentTag;
    private String username;

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

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.println("歡迎" + username + "的光臨");
        } catch (IOException ex) {
            }
        return Tag.EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
    }

}
