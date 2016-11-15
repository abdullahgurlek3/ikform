<%-- 
    Document   : login.jsp
    Created on : Aug 16, 2016, 3:57:23 PM
    Author     : Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login!</h1>
        <form:form  modelAttribute="Admin">
            <form:label path="username">Kullanıcı adı</form:label>
            <form:input path="username" type="text" /> <!-- bind to user.name-->
            <form:errors path="username" />
        <hr>
            <form:label path="password">Şifre</form:label>
            <form:input path="password" type="password" /> <!-- bind to user.name-->
            <form:errors path="password" />
        <hr>
        <input type="submit" />
        </form:form>
    </body>
</html>
