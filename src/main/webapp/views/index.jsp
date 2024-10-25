<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Course Portal</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css'></c:url>">
</head>
<body>
<div class="container">
    <h1>Student Course Portal</h1>
    <p>Manage Students and Courses below:</p>

    <h2>Students</h2>
    <ul>
        <li><a href="<c:url value='/students'></c:url>">List All Students</a></li>
        <li><a href="<c:url value='/students/add'></c:url>">Add New Student</a></li>
    </ul>

    <h2>Courses</h2>
    <ul>
        <li><a href="<c:url value='/courses'></c:url>">List All Courses</a></li>
        <li><a href="<c:url value='/courses/add'></c:url>">Add New Course</a></li>
    </ul>
</div>
</body>
</html>
