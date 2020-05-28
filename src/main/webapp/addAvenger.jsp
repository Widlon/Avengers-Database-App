<%-- 
    Document   : addAvenger
    Created on : May 28, 2020, 2:14:12 PM
    Author     : nishu
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mylib" uri="WEB-INF/tlds/avenger_library.tld" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Avenger</title>
    </head>
    <body>
        <h1>Add an Avenger</h1>
        <form action="AddAvenger.do" method="POST">
            Name: <input type="text" name="avengerName"><br><br>
            Description: <input type="text" name="avengerDescription"><br><br>
            Power Source:<mylib:powerSourceTag /> <br><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>

