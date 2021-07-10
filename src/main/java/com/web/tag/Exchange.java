package com.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/*
    USDJPY=x
    CNYEUR=x

    <my:exchange symbol="USDTWD" />
    1 USD 兌換 29.8 TWD
    <my:exchange symbol="USDTWD"  reverse="true" />
    1 USD 兌換 29.8 TWD
    1 TWD 兌換 0.034 USD
*/

public class Exchange implements Tag{
    private PageContext pageContent;
    private Tag parentTag;
        
    @Override
    public void setPageContext(PageContext pc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setParent(Tag tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tag getParent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int doStartTag() throws JspException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int doEndTag() throws JspException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void release() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
