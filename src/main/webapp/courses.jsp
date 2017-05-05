<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Курсы</title>
</head>
<body>
<h2>
    <a href="${pageContext.request.contextPath}/?logout=1">Log out</a><br>
    <%=request.getSession().getAttribute("userLogin")%>
</h2>

    <h2>Список курсов:</h2>
    <table>
        <c:forEach items="${requestScope.coursesList}" var="course">
            <tr>
                <td><c:out value="${course.name}"></c:out></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
