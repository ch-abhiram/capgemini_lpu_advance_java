<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>

<h2 align="center">Admin Dashboard - Employee Details</h2>

<table border="1" align="center" cellpadding="10">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Salary</th>
        <th>Role</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${list_of_employees}" var="emp">
        <tr>
            <td>${emp.name}</td>
            <td>${emp.email}</td>
            <td>${emp.salary}</td>
            <td>${emp.role}</td>
            <td>
                <form action="deleteRecord" method="post">
                    <input type="hidden" name="email" value="${emp.email}" />
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>