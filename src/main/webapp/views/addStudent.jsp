<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css'></c:url>">
</head>
<body>
<div class="container">
    <h1>Add New Student</h1>
    <form action="<c:url value='/students/add'></c:url>" method="post">
        <label for="name">Student Name:</label>
        <input type="text" id="name" name="name" required>
        <button type="submit">Add Student</button>
    </form>
    <a href="<c:url value='/students'></c:url>">Back to Students List</a>
</div>
</body>
</html>
