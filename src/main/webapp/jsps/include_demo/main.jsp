<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%  String message = "I Love Java嗨";%>
            <%@include file= "title.jsp" %> <!-- 靜態include 不能帶參數在執行前就在main先編譯好了 -->
        </h1>
        <h1>
            <!-- 動態 include 可以帶參數在網頁跑的時候才會執行 -->
            <jsp:include page="salary.jsp?salary=10&salary=20">
                <jsp:param name="message" value= "<%=message %>" />
                <jsp:param name="salary" value="40000" />
                <jsp:param name="salary" value="50000" />
            </jsp:include>
        </h1>
    </body>
</html>
