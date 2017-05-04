<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Курсы</title>
</head>
<body>
<h2>
    <%=request.getAttribute("coursesList2")%>
    <%=request.getAttribute("userLogin2")%>
    <%=request.getSession().getAttribute("userLogin")%>
    <c:out value="${trip.trips_pkey}"></c:out>
    <c:out value="${userLogin2}"></c:out>
    <%=((List)request.getAttribute("coursesList")).size()%>
    <%=((String)request.getAttribute("userLogin"))%>
</h2>

    <h2>Список курсов:</h2>
    <table>
        <c:forEach items="${requestScope.coursesList}" var="course">
            <tr>
                <td><c:out value="${course.name}"></c:out></td>
                <%--<td>${course.name}</td>--%>
            </tr>
        </c:forEach>
    </table>

<a href="${pageContext.request.contextPath}/?logout=1">Log out</a>
</body>
</html>
