<%--
  Created by IntelliJ IDEA.
  User: vadim
  Date: 05.05.2017
  Time: 7:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>


<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Edit list of courses</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="${pageContext.request.contextPath}/?logout=1">Log out</a>

<br/>
<br/>

<h1>List of courses</h1>


<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Name</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${requestScope.coursesList}" var="course">
        <tr>
            <td>${course.id}</td>
            <td>${course.name}</td>
            <td><a href="<c:url value='/edit/${course.id}'/>">Edit</a></td>
            <td><a href="<c:url value='/editcourses/remove/${course.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>


<h1>Add a Course</h1>

<form method="post" action="/editcourses/add">
    <table>

        <tr>
            <td>
                Name
            </td>
            <td>
                <input type="text" name="course_name"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Add course"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

