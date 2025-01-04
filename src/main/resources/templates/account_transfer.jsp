<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Account Transfer</title>
</head>
<body>
    <h1>Account Transfer</h1>
    <form action="/accounts/transfer" method="post">
        <label for="fromAccount">From Account:</label>
        <input type="text" id="fromAccount" name="fromAccount" required/><br>
        <label for="toAccount">To Account:</label>
        <input type="text" id="toAccount" name="toAccount" required/><br>
        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" required/><br>
        <button type="submit">Transfer</button>
    </form>
</body>
</html>
