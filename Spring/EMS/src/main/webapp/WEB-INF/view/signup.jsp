<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Signup</title>

    <style>
        body {
            margin: 0;
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif;
            background-color: #f4f6f8;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .card {
            background: #ffffff;
            padding: 30px;
            width: 350px;
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.08);
        }

        h2 {
            margin-bottom: 20px;
            font-weight: 500;
            color: #222;
            text-align: center;
        }

        label {
            font-size: 13px;
            color: #555;
            display: block;
            margin-bottom: 5px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
        }

        input:focus {
            outline: none;
            border-color: #333;
        }

        button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background: #111;
            color: white;
            font-size: 14px;
            cursor: pointer;
        }

        button:hover {
            background: #333;
        }
    </style>
</head>

<body>

<div class="card">
    <h2>Employee Signup</h2>

    <form action="/register" method="post">

        <label>Name</label>
        <input type="text" name="name" required>

        <label>Role</label>
        <input type="text" name="role" required>

        <label>Email</label>
        <input type="email" name="email" required>

        <label>Password</label>
        <input type="password" name="password" minlength="6" required>

        <label>Salary</label>
        <input type="number" name="salary" step="0.01" required>

        <button type="submit">Register</button>

    </form>
</div>

</body>
</html>