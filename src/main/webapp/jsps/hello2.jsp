<%-- 
    Document   : hello2
    Created on : 2021/6/25, 下午 08:45:16
    Author     : No Name
--%>  

<%@page import="java.util.Random" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--
<% %> scriptlet 配置在 _jspService()內  方法內
<%= %> expression 配置在 _jspService()內 ex: out.print(1+1); 方法內
<%! %> declare 物件變數, 方法 配置在 _jspService()外 方法外
--%>
<% int x = 100;%>
<%! int x = 200;%>
<%=x %>
<%=this.x %>
<% out.println(getLotto()); %>
<%!
    int getLotto() {
        return new Random().nextInt(100);
    }
%>
