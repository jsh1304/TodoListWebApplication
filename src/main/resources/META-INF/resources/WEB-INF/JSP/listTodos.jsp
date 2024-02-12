 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <title> Todo Lists 페이지 </title>
    </head>
    <body>
        <div> 환영합니다. ${name} </div>
        <hr>
        <H1> 당신의 할일 </H1>
        <table>
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
    </body>
</html>