<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Students List</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css'></c:url>">
</head>
<body>
<div class="container">
    <h1>Students List</h1>
    <div class="table-container">
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Courses Enrolled</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td><a href="<c:url value='/students/details/${student.id}'></c:url>">${student.name}</a></td>
                    <td>
                        <c:forEach var="course" items="${student.courses}">
                            ${course.name}<br>
                        </c:forEach>
                    </td>
                    <td>
                        <a href="<c:url value='/students/edit/${student.id}'></c:url>">Edit</a> |
                        <a href="<c:url value='/students/delete/${student.id}'></c:url>">Delete</a> |
                        <a href="<c:url value='/students/register/${student.id}'></c:url>">Register in Course</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <a href="<c:url value='/students/add'></c:url>">Add New Student</a>
</div>
</body>
</html>