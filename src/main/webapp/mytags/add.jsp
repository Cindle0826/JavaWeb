<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/tlds/mytld" prefix="my" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <my:add x="10.5" y="20" />
        </h1>
        <h1>
            <my:add x="10.5" y="20" z = "30.5" />
        </h1>
    </body>
</html>
