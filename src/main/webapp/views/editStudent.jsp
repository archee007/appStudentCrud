<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css'/>">
</head>
<body>
<div class="container">
    <h1>Edit Student</h1>
    <form action="<c:url value='/students/update' />" method="post">
        <input type="hidden" name="id" value="${student.id}">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${student.name}" required>
        <button type="submit">Update Student</button>
    </form>
    <a href="<c:url value='/students' />">Back to Students List</a>
</div>
</body>
</html>
