<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${app.name} - ${app.version}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/styles.css">
</head>
<body>
    <header>
        <div class="logo">
            <h1><a href="${pageContext.request.contextPath}/">AfleX Banking</a></h1>
        </div>
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/accounts/transfer">Account Transfer</a></li>
                <li><a href="${pageContext.request.contextPath}/bills/payment">Bill Payment</a></li>
                <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
            </ul>
        </nav>
    </header>
