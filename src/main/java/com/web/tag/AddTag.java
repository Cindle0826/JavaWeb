package com.web.tag;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/*
    <my:add x=1 y=2 />
    <my:add x=1 y=2 z=3 ... />
    加法器
 */
public class AddTag extends SimpleTagSupport implements DynamicAttributes {

    private Map<String, Double> map = new LinkedHashMap<>();

    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        map.put(localName, Double.parseDouble(value + ""));
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
//        double sum = map.entrySet().stream().mapToDouble(e -> e.getValue()).sum();
        double sum = map.entrySet().stream().mapToDouble(Entry::getValue).sum();
        out.println(sum);
    }

}
