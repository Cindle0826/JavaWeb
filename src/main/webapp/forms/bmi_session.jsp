<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
        <title>BMI</title>
    </head>
    <body style="padding: 20px">

        <form class="pure-form" 
              enctype="application/x-www-form-urlencoded"
              method="post" action="/JavaEE_Web/controller/bmi_session">
            <fieldset>
                <legend>BMI (Session版) &nbsp; 使用人數:${ applicationScope.count } 人</legend>
                <input name="cname" type="text" placeholder="姓名" value=""><p /> 
                <input name="height" type="text" placeholder="身高" value=""><p /> 
                <input name="weight" type="text" placeholder="體重" value=""><p />
                <input name="code" type="text" placeholder="請輸入授權碼">
                <img src="/JavaEE_Web/controller/authcode" valign="middle" /><p />
                <p />
                <button type="submit" class="pure-button pure-button-primary">傳送</button>
                <button type="button" onclick="location.href = '/JavaEE_Web/controller/bmi_session'" class="pure-button pure-button-primary">檢視</button>
                <button type="button" onclick="location.href = '/JavaEE_Web/controller/bmi_session_invalid'" class="pure-button pure-button-primary">刪除session資料</button>

            </fieldset>
        </form>


    </body>
</html>
