<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>User Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f9;
        }

        .card {
            width: 400px;
            margin: 80px auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0px 0px 10px #ccc;
            border-radius: 8px;
        }

        h2 {
            text-align: center;
        }

        p {
            font-size: 18px;
            margin: 10px 0;
        }

        span {
            font-weight: bold;
            color: #2c3e50;
        }
    </style>
</head>
<body>
<p th:text="${user}"></p>

<div class="card" th:object="${user}">
    <h2>User Details</h2>

    <p>Name: <span th:text="*{name}"></span></p>
    <p>Email: <span th:text="*{email}"></span></p>
    <p>Salary: <span th:text="*{salary}"></span></p>
    <p>Role: <span th:text="*{role}"></span></p>
</div>

</body>
</html>