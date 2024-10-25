<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register Student in Course</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css'/>">
</head>
<body>
<div class="container">
    <h1>Register Student in Course</h1>
    <form action="<c:url value='/students/registerStudentInCourse' />" method="post">
        <input type="hidden" name="studentId" value="${student.id}">

        <label for="courseId">Select Course:</label>
        <select id="courseId" name="courseId" required>
            <c:forEach var="course" items="${courses}">
                <option value="${course.id}">${course.name}</option>
            </c:forEach>
        </select>

        <button type="submit">Register</button>
    </form>
    <a href="<c:url value='/students' />">Back to Students List</a>
</div>
</body>
</html>
