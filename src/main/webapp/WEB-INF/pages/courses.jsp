<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Курсы</title>
</head>
<body>
<h3>
    <a href="${pageContext.request.contextPath}/?logout=1">Log out</a><br>
    <%=request.getSession().getAttribute("userLogin")%>
</h3>

    <h3>Список курсов:</h3>
    <table>
        <c:forEach items="${requestScope.coursesList}" var="course">
            <tr>
                <td><c:out value="${course.name}"></c:out></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
