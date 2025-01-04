<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Data Upload</title>
</head>
<body>
    <h1>Upload Customer Data</h1>
    <form action="/customers/upload" method="post" enctype="multipart/form-data">
        <label for="file">Choose File:</label>
        <input type="file" id="file" name="file" required/><br>
        <button type="submit">Upload</button>
    </form>
</body>
</html>
