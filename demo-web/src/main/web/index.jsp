<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>导出数据</title>
</head>
<body>
    <input type="button" value="导出数据" onclick="download()"/>
    <script type="text/javascript">
        function download(){
        var url="/demo/download";
        window.open(url);
        }
    </script>
</body>


</html>