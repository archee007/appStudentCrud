<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Course Details</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css'></c:url>">
</head>
<body>
<div class="container">
    <h1>Course: ${course.name}</h1>
    <h2>Enrolled Students:</h2>
    <ul>
        <c:forEach var="student" items="${course.students}">
            <li>${student.name}</li>
        </c:forEach>
    </ul>
    <a href="<c:url value='/courses'></c:url>">Back to Courses List</a>
</div>
</body>
</html>
