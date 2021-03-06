<%@page import="com.web.rest.bookstore.BookDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

        <script type="text/javascript">
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {

                var data = google.visualization.arrayToDataTable([
                    ['Name', 'Amount'],
                    <c:forEach var="bsv" items="${ BookDAO.getBookStatViews() }">
                        ['${ bsv.name }', ${ bsv.amount }],
                    </c:forEach>
                ]);

                var options = {
                    title: 'Book 數量統計 ', is3D: true
                };
                // BarChart, PieChart, ColumnChart, LineChart 
                var chart = new google.visualization.BarChart(document.getElementById('piechart'));

                chart.draw(data, options);
            }
        </script>

        <script>
            function deleteConfirm() {
                var value = window.confirm('是否要刪除 ?');
                return value;
            }

            // 較新的瀏覽器中已經有提供btoa和atob兩個全域函式，可以用來做base64的encode和decode
            function updateBook(base64str) {
                console.log(base64str)
                console.log(atob(base64str));
                var jsonStr = atob(base64str);
                var book = JSON.parse(jsonStr)
                document.getElementById('uId').value = book.id;
                document.getElementById('uName').value = book.name;
                document.getElementById('uPrice').value = book.price;
                document.getElementById('uAmount').value = book.amount;
            }

            function deleteBook(id) {
                document.getElementById('dId').value = id;
            }

            // 使用 utf-8 進行編碼 base64
            function utoa(str) {
                return window.btoa(unescape(encodeURIComponent(str)));
            }

            // 使用 utf-8 進行解析 base64
            function atou(str) {
                return decodeURIComponent(escape(window.atob(str)));
            }

        </script>


    </head>
    <body style="padding: 20px">
        <table>
            <!-- Rest Book List -->
            <td valign="top">
                <form class="pure-form">
                    <fieldset>
                        <legend>Rest Book List</legend>
                        <table class="pure-table pure-table-bordered">
                            <thead>
                                <tr>
                                    <th>id</th>
                                    <th>name</th>
                                    <th>price</th>
                                    <th>amount</th>
                                    <th>修改</th>
                                    <th>刪除</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="book" items="${ BookDAO.getBooks() }">
                                    <tr>
                                        <td>${ book.id }</td>
                                        <td>${ book.name } </td>
                                        <td>${ book.price }</td>
                                        <td>${ book.amount }</td>
                                        <td>
                                            <button type="button" 
                                                    onclick="updateBook('${ book }')"
                                                    class="pure-button pure-button-primary">修改</button>
                                        </td>
                                        <td>
                                            <button type="button"
                                                    onclick="deleteBook(${ book.id })"
                                                    class="pure-button pure-button-primary">刪除</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </fieldset>
                </form>
            </td>
            <!-- Rest Book Chart -->
            <td valign="top">
                <form class="pure-form">
                    <fieldset>
                        <legend>Rest Book Chart</legend>
                        <div id="piechart" style="width: 900px; height: 500px;"></div>
                    </fieldset>
                </form>
            </td>
        </table>

        <table>
            <!-- Insert Book -->
            <td valign="top">
                <form class="pure-form"
                      method="post" action="/JavaEE_Web/rest/book">
                    <fieldset>
                        <legend>Rest Book POST</legend>
                        <input name="id" type="hidden"  placeholder="id" value="0">
                        <input name="name" type="text" placeholder="名稱"><p /> 
                        <input name="price" type="text" placeholder="價格"><p />
                        <input name="amount" type="text" placeholder="數量"><p />
                        <p />
                        <button type="submit" 
                                class="pure-button pure-button-primary">新增</button>

                    </fieldset>
                </form>
            </td>
            <!-- Update Book -->
            <td valign="top">
                <form class="pure-form"
                      method="post" action="/JavaEE_Web/rest/book">
                    <fieldset>
                        <legend>Rest Book PUT</legend>
                        <input name="_method" type="hidden" value="PUT" />
                        <input id="uId" name="id" type="text" placeholder="id" readonly><p /> 
                        <input id="uName" name="name" type="text" placeholder="名稱"><p /> 
                        <input id="uPrice" name="price" type="text" placeholder="價格"><p />
                        <input id="uAmount" name="amount" type="text" placeholder="數量"><p />
                        <p />
                        <button type="submit" 
                                class="pure-button pure-button-primary">修改</button>

                    </fieldset>
                </form>
            </td>
            <!-- Delete Book -->
            <td valign="top">
                <form class="pure-form"
                      onsubmit="return deleteConfirm()"
                      method="post" action="/JavaEE_Web/rest/book">
                    <fieldset>
                        <legend>Rest Book Delete</legend>
                        <input name="_method" type="hidden" value="DELETE" />
                        <input id="dId" name="id" type="text" placeholder="id" readonly><p /> 
                        <p />
                        <button type="submit" 
                                class="pure-button pure-button-primary">刪除</button>

                    </fieldset>
                </form>    
            </td>
        </table>
    </body>
</html>
