
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>ABC Page</title>

    <style>
        body {
            font-family: Arial;
            background-color: #f4f4f4;
            text-align: center;
            margin-top: 100px;
        }

        .box {
            background-color: white;
            width: 300px;
            margin: auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px gray;
        }

        h2 {
            color: green;
        }
    </style>
</head>
<body>

<div class="box">
    <h1>Message from Controller</h1>
    <c:forEach var="name" items="${msg}">
    <h2>${name} welcome</h2>
    </c:forEach>
</div>

</body>
</html>