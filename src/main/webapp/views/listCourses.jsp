<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Courses List</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css'></c:url>">
</head>
<body>
<div class="container">
    <h1>Courses List</h1>
    <div class="table-container">
        <table>
            <thead>
            <tr>
                <th>Course Name</th>
                <th>Students Enrolled</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td><a href="<c:url value='/courses/details/${course.id}'></c:url>">${course.name}</a></td>
                    <td>
                        <c:forEach var="student" items="${course.students}">
                            ${student.name}<br>
                        </c:forEach>
                    </td>
                    <td>
                        <a href="<c:url value='/courses/edit/${course.id}'></c:url>">Edit</a> |
                        <a href="<c:url value='/courses/delete/${course.id}'></c:url>">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <a href="<c:url value='/courses/add'></c:url>">Add New Course</a>
</div>
</body>
</html>
