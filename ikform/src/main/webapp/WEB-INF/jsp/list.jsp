<%-- 
    Document   : login.jsp
    Created on : Aug 16, 2016, 3:57:23 PM
    Author     : Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Başvuru Listesi</h1>
        <table>
            <thead>
            <th>Ad Soyad</th>
            <th>Dogum Yeri</th>
            <th>Dogum tarihi</th>
            <th>Cinsiyet</th>
            <th>Evlilik Durumu</th>
            <th>Sürücü Belgesi</th>
            <th>Telefon No</th>
            <th>Gsm No</th>
            <th>Address</th>
            <th>Eğitim</th>
            <th>Deneyim</th>
            <th>Not</th>
        </thead>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.nameAndSurname}</td>
                <td>${user.birthPlace}</td>
                <td>${user.birthDate}</td>    
                <td>${user.gender}</td>
                <td>${user.maritalStatus}</td>
                <td>${user.drivingLicense}</td>
                <td>${user.telephoneNo}</td>
                <td>${user.gsmNo}</td>
                <td>${user.address}</td>
                <td>${user.education}</td>
                <td>${user.experience}</td>

                <td>${user.noteText}</td>

            </tr>
        </c:forEach>
    </table>

</body>
</html>
