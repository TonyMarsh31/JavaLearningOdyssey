<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加品牌</title>
</head>
<body>
<h3>添加品牌</h3>
<form action="/MVC-Demo/addServlet" method="post">
    <label>
        品牌名称：
        <input name="brandName">
    </label><br>
    <label>
        企业名称：
        <input name="companyName">
    </label><br>
    <label>
        排序：
        <input name="ordered">
    </label><br>
    <label>
        描述信息：
        <textarea rows="5" cols="20" name="description"></textarea>
    </label><br>
    状态：
    <label>
        禁用
        <input type="radio" name="status" value="0">
    </label>
    <label>
        启用
        <input type="radio" name="status" value="1">
    </label><br>

    <input type="submit" value="提交">
</form>
</body>
</html>