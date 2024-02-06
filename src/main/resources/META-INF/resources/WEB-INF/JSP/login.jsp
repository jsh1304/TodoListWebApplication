<html>
    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <title> 로그인 페이지 </title>
    </head>
    <body>
        로그인 페이지!

        <pre> ${errorMessage} </pre>
        <form method="post">
            이름: <input type="text" name="name">
            비밀번호: <input type="password" name="password">
            <input type="submit">
        </form>
    </body>
</html>