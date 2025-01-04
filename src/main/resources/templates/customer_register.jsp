<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Registration</title>
</head>
<body>
    <h1>Customer Registration</h1>
    <form action="/customers/register" method="post">
        <label for="name">Customer Name:</label>
        <input type="text" id="name" name="name" required/><br>
        <label for="email">Customer Email:</label>
        <input type="email" id="email" name="email" required/><br>
        <button type="submit">Register Customer</button>
    </form>
</body>
</html>
