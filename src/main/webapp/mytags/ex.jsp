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
            <my:exchange symbol="USDTWD=x" />
        </h1>

        <h1>
            <my:exchange symbol="TWDUSD=x222" />
        </h1>
    </body>
</html>
