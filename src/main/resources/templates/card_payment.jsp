<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Card Payment</title>
</head>
<body>
    <h1>Card Payment</h1>
    <form action="/payments/card" method="post">
        <label for="cardNumber">Card Number:</label>
        <input type="text" id="cardNumber" name="cardNumber" required/><br>
        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" required/><br>
        <button type="submit">Pay with Card</button>
    </form>
</body>
</html>
