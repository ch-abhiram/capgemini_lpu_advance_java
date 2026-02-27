<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Register</title>

    <style>
        body {
            margin: 0;
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif;
            background-color: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .card {
            background: #ffffff;
            padding: 30px;
            width: 320px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
        }

        h1 {
            font-size: 20px;
            font-weight: 500;
            margin-bottom: 20px;
            color: #222;
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
            padding: 8px;
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
    <h1>Register</h1>

    <form action="/create-account" method = "post">
        <label>Name</label>
        <input type="text" name="name" required>

        <label>Email</label>
        <input type="email" name="email" required>

        <label>Contact</label>
        <input type="number" name="number" required>

        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>