<%-- 
    Document   : CalcAreaResult
    Created on : 2021/6/7, 下午 08:26:09
    Author     : No Name
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>計算<%=request.getAttribute("typeName")%>結果</title>
    <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css" >
</head>
<body style="padding: 20px">
    <form class="pure-form" method ="post" action ="/JavaEE_Web/controller/CalcArea" >
        <fieldset>
            <legend style="color: #005100">計算<%=request.getAttribute("typeName")%>結果</legend>
            半徑：<font color="#0000ff"><%=request.getAttribute("r")%></font><p />
            結果：<font color="#ff0000"><%=request.getAttribute("result")%></font><br><p/>
            <button onclick="window.history.back() " type="button" class="pure-button pure-button-primary">回上一頁</button>
        </fieldset>
    </form>
</body>
</html>
