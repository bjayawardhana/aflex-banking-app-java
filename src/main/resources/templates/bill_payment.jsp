<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bill Payment</title>
</head>
<body>
    <h1>Bill Payment</h1>
    <form action="/bills/payment" method="post">
        <label for="billType">Bill Type:</label>
        <input type="text" id="billType" name="billType" required/><br>
        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" required/><br>
        <button type="submit">Pay Bill</button>
    </form>
</body>
</html>
