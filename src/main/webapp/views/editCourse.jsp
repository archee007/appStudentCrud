<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Course</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css'/>">
</head>
<body>
<div class="container">
    <h1>Edit Course</h1>
    <form action="<c:url value='/courses/update' />" method="post">
        <input type="hidden" name="id" value="${course.id}">
        <label for="name">Course Name:</label>
        <input type="text" id="name" name="name" value="${course.name}" required>
        <button type="submit">Update Course</button>
    </form>
    <a href="<c:url value='/courses' />">Back to Courses List</a>
</div>
</body>
</html>
