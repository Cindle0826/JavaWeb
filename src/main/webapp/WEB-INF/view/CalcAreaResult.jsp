<%-- 
    Document   : CalcAreaResult
    Created on : 2021/6/7, 下午 08:26:09
    Author     : No Name
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>計算<%=request.getAttribute("typeName")%>結果</title>
    <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css" >
</head>
<body style="padding: 20px">
<% List<Map> list = (List)request.getAttribute("list"); %>
<% for(Map map: list){ %>
<% if(map.get("r").toString().equals("0")) continue; //map沒給泛型所以要印toString %>
    <form class="pure-form" method ="post" action ="/JavaEE_Web/controller/CalcArea" >
        <fieldset>
            <legend style="color: #005100">計算<%=map.get("name")%>結果</legend>
            半徑：<font color="#0000ff"><%=map.get("r")%></font><p />
            結果：<font color="#ff0000"><%=map.get("result")%></font><br><p/>
            <button onclick="window.history.back() " type="button" class="pure-button pure-button-primary">回上一頁</button>
        </fieldset>
    </form>
<% } %>       
</body>

</html>
