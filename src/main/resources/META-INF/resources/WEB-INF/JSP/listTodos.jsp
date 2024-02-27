<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <h1> 당신의 할일 </h1>
    <table class="table">
        <thead>
            <tr>
                <th>설명</th>
                <th>목표 날짜</th>
                <th>완료</th>
                <th></th>
            <tr>
        </thead>
        <tbody>
            <c:forEach items="${todos}" var ="todo">
                <tr>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                    <td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning">삭제</a> </td>
                    <td> <a href="update-todo?id=${todo.id}" class="btn btn-success">업데이트</a> </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">todo 추가하기</a>
</div>

<%@ include file="common/footer.jspf" %>