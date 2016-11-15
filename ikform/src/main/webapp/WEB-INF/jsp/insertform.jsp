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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form:form  modelAttribute="User">
            <form:label path="nameAndSurname">İsim ve Soyisim</form:label>
            <form:input path="nameAndSurname" type="text" /> <!-- bind to user.name-->
            <form:errors path="nameAndSurname" />
        <hr>
            <form:label path="birthPlace">Doğum yeri</form:label>            
            <form:input path="birthPlace" type="text" /> <!-- bind to user.name-->
            <form:errors path="birthPlace" />
        <hr>
            <form:label path="birthDate">Doğum Tarihi</form:label>            
            <form:input path="birthDate" type="text" /> <!-- bind to user.name-->
            <form:errors path="birthDate" />
        <hr>
            <form:label path="birthDate">Cinsiyet</form:label>            
            <form:select path="gender" type="select">
                <form:option value="Erkek" />
                <form:option value="Kız" />
                <form:option value="Diğer" />
            </form:select>
            <form:errors path="gender" />
        <hr>
            <form:label path="maritalStatus">Evlilik Durum</form:label>            
            <form:select path="maritalStatus" type="select">
                <form:option value="Evli" />
                <form:option value="Bekar" />
                <form:option value="Boşanmış" />
                <form:option value="Diğer" />
            </form:select>
            <form:errors path="maritalStatus" />
        <hr>
            <form:label path="drivingLicense">Ehliyet Belgesi</form:label>            
            <form:checkbox path="drivingLicense" /> <!-- bind to user.name-->
            <form:errors path="drivingLicense" />
        <hr>
            <form:label path="telephoneNo">Telefon No :</form:label>            
            <form:input path="telephoneNo" type="text" /> <!-- bind to user.name-->
            <form:errors path="telephoneNo" />
        <hr>
            <form:label path="gsmNo">Gsm No :</form:label>            
            <form:input path="gsmNo" type="text" /> <!-- bind to user.name-->
            <form:errors path="gsmNo" />
        <hr>
            <form:label path="address">Address :</form:label>            
            <form:textarea path="address" type="text" /> <!-- bind to user.name-->
            <form:errors path="address" />
        <hr>
            <form:label path="postalCode">Posta Kodu:</form:label>            
            <form:input path="postalCode" type="text" /> <!-- bind to user.name-->
            <form:errors path="postalCode" />
        <hr>
            <form:label path="city">Şehir:</form:label>            
            <form:input path="city" type="text" /> <!-- bind to user.name-->
            <form:errors path="city" />

        <hr>
            <form:label path="email">Mail Adresi:</form:label>            
            <form:input path="email" type="text" /> <!-- bind to user.name-->
            <form:errors path="email" />
        <hr>
            <form:label path="education">Eğitimler :</form:label>            
            <form:textarea path="education" type="text" /> <!-- bind to user.name-->
            <form:errors path="education" />
        <hr>
            <form:label path="experience">Deneyimler :</form:label>            
            <form:textarea path="experience" type="text" /> <!-- bind to user.name-->
            <form:errors path="experience" />
        <hr>
            <form:label path="noteText">Notlar :</form:label>            
            <form:textarea path="noteText" type="text" /> <!-- bind to user.name-->
            <form:errors path="noteText" />
        <hr>

        <input type="submit" />
        </form:form>
    </body>
</html>
