<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="user/findAll">测试</a>
<a href="addUser.jsp">增加用户</a>

<form action="user/fileupload" method="post" enctype="multipart/form-data">
    上传文件：<input type="file" name="upload" id="upload"/><br/>
    <input type="submit" value="提交"/>
</form>


</body>
</html>
