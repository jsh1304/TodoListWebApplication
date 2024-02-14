<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="webjars\bootstrap\5.3.0\css\bootstrap.min.css" rel="stylesheet">
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <title> Todo 추가하기 페이지 </title>
    </head>
    <body>
        <div class="container">
            <H1> Todo 세부사항을 입력하세요 </H1>
            <form:form method="post" modelAttribute="todo">
                설명: <form:input type="text" path="description"
                                required="required"/>
                <form:input type="hidden" path="id"/>
                <form:input type="hidden" path="done"/>
                <input type="submit" class="btn btn-success"/>
            </form:form>
        </div>
        <script src="webjars\bootstrap\5.3.0\js\bootstrap.min.js"></script>
        <script src="webjars\jquery\3.6.0\jquery.min.js"></script>
    </body>
</html>