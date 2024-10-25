<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Course</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css'></c:url>">
</head>
<body>
<div class="container">
    <h1>Add New Course</h1>
    <form action="<c:url value='/courses/add'></c:url>" method="post">
        <label for="name">Course Name:</label>
        <input type="text" id="name" name="name" required>
        <button type="submit">Add Course</button>
    </form>
    <a href="<c:url value='/courses'></c:url>">Back to Courses List</a>
</div>
</body>
</html>
