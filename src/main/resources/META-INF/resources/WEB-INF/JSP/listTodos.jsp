 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link href="webjars\bootstrap\5.3.0\css\bootstrap.min.css" rel="stylesheet">
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <title> Todo Lists 페이지 </title>
    </head>
    <body>
        <div class="container"></div>
            <h1> 당신의 할일 </h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>설명</th>
                        <th>목표 날짜</th>
                        <th>완료</th>
                    <tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var ="todo">
                        <tr>
                            <td>${todo.id}</td>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-success">todo 추가하기</a>
        <script src="webjars\bootstrap\5.3.0\js\bootstrap.min.js"></script>
        <script src="webjars\jquery\3.6.0\jquery.min.js"></script>
    </body>
</html>