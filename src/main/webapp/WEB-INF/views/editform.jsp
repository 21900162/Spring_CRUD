<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="board.BoardDAO" %>
<%@ page import="board.BoardVO" %><%--
  Created by IntelliJ IDEA.
  User: UserK
  Date: 2022-12-02
  Time: 오후 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Edit Form</title>
</head>
<body>

<%--<%--%>
<%--  BoardDAO boardDAO = new BoardDAO();--%>
<%--  String id=request.getParameter("id");--%>
<%--  BoardVO u=boardDAO.getBoard(Integer.parseInt(id));--%>
<%--%>--%>

<h1>Edit Form</h1>

<form:form modelAttribute = "boardVO" method = "POST" action = "../editok">
  <form:hidden path ="id"/>
  <table id = "edit">
    <tr>
      <td>종류:</td>
      <td><form:select name="category" path="category">
        <option value="">종류선택</option>
        <option value="한식">한식</option>
        <option value="중식">중식</option>
        <option value="일식">일식</option>
        <option value="베트남 음식">베트남 음식</option>
      </form:select></td>
    </tr>
    <tr><td>요리이름</td><td><form:input path = "name"/></td></tr>
    <tr><td>요리순서</td><td><form:textarea cols="50" rows ="5" path = "instruction"/></td></tr>
  </table>
  <input type="submit" value="수정하기"/>
  <input type="button" value="취소하기" onclick="history.back()"/>
</form:form>

</body>
</html>