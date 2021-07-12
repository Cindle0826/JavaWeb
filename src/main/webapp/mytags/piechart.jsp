<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/tlds/mytld" prefix="my" %>
<%@taglib prefix="pie" tagdir="/WEB-INF/tags" %>
             
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <pie:piechart work="8"  eat="2" commut="5" sleep="8" watchTv="1" is3d="true"/>

        </h1>

    </body>
</html>
