<%--
  Created by IntelliJ IDEA.
  User: UserK
  Date: 2022-12-02
  Time: 오후 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h1>Add New Post</h1>
<form action="addok" method="post">
    <table>
        <tr><td>요리종류:</td><td><select name="category">
            <option value="">없음</option>
            <option value="한식">한식</option>
            <option value="중식">중식</option>
            <option value="일식">일식</option>
            <option value="베트남 음식">베트남 음식</option>
        </select></td></tr>
        <tr><td>요리이름:</td><td><input type="text" name="name"/></td></tr>
        <tr><td>요리순서:</td><td><textarea cols="50" rows="5" name="instruction"> </textarea></td></tr>
        <tr><td><a href="list.jsp">View All Records</a></td><td align="right"><input type="submit" value="Add Post"/></td></tr>
    </table>
</form>

</body>
</html>
