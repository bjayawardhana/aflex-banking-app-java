<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Loan Payment</title>
</head>
<body>
    <h1>Loan Payment</h1>
    <form action="/loans/payment" method="post">
        <label for="loanNumber">Loan Number:</label>
        <input type="text" id="loanNumber" name="loanNumber" required/><br>
        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" required/><br>
        <button type="submit">Pay Loan</button>
    </form>
</body>
</html>
