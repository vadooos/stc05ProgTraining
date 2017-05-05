<%--
  Created by IntelliJ IDEA.
  User: vadim
  Date: 24.04.2017
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form method="post" action="/registration">
    <tr>
        <td>Логин</td>
        <td>
            <input type="text" name="user_login" required="required"/>
        </td>
    </tr><br>
    <tr>
        <td>Пароль</td>
        <td>
            <input type="text" title ="Должен быть не менее 4 символов" name="user_password" required="required" pattern="[a-zA-Z0-9\d]{4,20}" />
        </td>
    </tr><br>
    <tr>
        <td>Имя</td>
        <td>
            <input type="text" name="user_firstname" required="required"/>
        </td>
    </tr><br>
    <tr>
        <td>Фамилия</td>
        <td>
            <input type="text" name="user_lastname" required="required"/>
        </td>
    </tr><br>
    <tr>
        <td>
            <input type="submit" value="register"/>
        </td>
    </tr><br>
</form>
</body>
</html>
