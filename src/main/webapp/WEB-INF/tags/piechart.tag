<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="work" required="true" rtexprvalue="true" %>
<%@attribute name="eat" required="true" rtexprvalue="true" %>
<%@attribute name="commut" required="true" rtexprvalue="true" %>
<%@attribute name="watchTv" required="true" rtexprvalue="true" %>
<%@attribute name="sleep" required="true" rtexprvalue="true" %>
<%@attribute name="is3d" required="false" rtexprvalue="true"  %>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

        var data = google.visualization.arrayToDataTable([
            ['Task', 'Hours per Day'],
            ['Work', ${ work }],
            ['Eat', ${ eat }],
            ['Commute', ${ commut }],
            ['Watch TV', ${ watchTv }],
            ['Sleep', ${ sleep }]
        ]);

        var options = {
            title: 'My Daily Activities',is3D: ${ is3d }  //3D圖表  加上 is3D
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
    }
</script>

<div id="piechart" style="width: 900px; height: 500px;"></div>