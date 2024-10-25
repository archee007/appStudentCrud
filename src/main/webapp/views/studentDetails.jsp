<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css'></c:url>">
</head>
<body>
<div class="container">
    <h1>Student: ${student.name}</h1>
    <h2>Enrolled Courses:</h2>
    <ul>
        <c:forEach var="course" items="${student.courses}">
            <li>${course.name}</li>
        </c:forEach>
    </ul>
    <a href="<c:url value='/students'></c:url>">Back to Students List</a>
</div>
</body>
</html>
