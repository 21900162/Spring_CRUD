<%@ page import="com.example.board.BoardDAO" %>
<%@ page import="com.example.board.BoardVO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: UserK
  Date: 2022-11-25
  Time: 오전 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>free board</title>
    <style>
        #list {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        #list td, #list th {
            border: 1px solid #ddd;
            padding: 8px;
            text-align:center;
        }
        #list tr:nth-child(even){background-color: #f2f2f2;}
        #list tr:hover {background-color: #ddd;}
        #list th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: center;
            background-color: #006bb3;
            color: white;
        }

    </style>
    <script>
        function delete_ok(id){
            var a = confirm("정말로 삭제하겠습니까?");
            if(a) location.href='deleteok/' + id;
        }
    </script>
</head>
<body>
<h1>요리게시판</h1>
<%--<%--%>
<%--    BoardDAO boardDAO = new BoardDAO();--%>
<%--    List<BoardVO> list = boardDAO.getBoardList();--%>
<%--    request.setAttribute("list",list);--%>
<%--%>--%>
<table id="list" width="90%">
    <tr>
        <th>Id</th>
        <th>Category</th>
        <th>Name</th>
        <th>Instruction</th>
        <th>Regdate</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.category}</td>
            <td>${u.name}</td>
            <td><div style="white-space: pre-line">
                <c:out value="${u.instruction}"/>
            </div> </td>
            <td>${u.regdate}</td>
            <td><a href="editform/${u.getId()}">Edit</a></td>
            <td><a href="javascript:delete_ok('${u.getId()}')">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/><a href="add">Add New Post</a>
</body>
</html>