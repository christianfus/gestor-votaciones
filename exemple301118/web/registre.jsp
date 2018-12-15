<%-- 
    Document   : registre
    Created on : 04-dic-2018, 11:15:17
    Author     : Fidel_pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <% if(request.getAttribute("missatge")!=null) {
            out.print(request.getAttribute("missatge"));
        } %>
        <div>
        <form action="valida02.jsp" method="POST">
            <label>Usuari:</label>
            <input type="text" name="usuari"/><br/>
            <label>Contrasenya:</label>
            <input type="password" name="contrasenya"/><br/>
            <label>Nom:</label>
            <input type="text" name="nom"/><br/>
            <label>Cognoms:</label>
            <input type="text" name="cognoms"/><br/>
            <label>Població:</label>
            <input type="text" name="poblacio"/><br/>
            <br/>
            <input type="submit" name="boto2" value="Entrar"/>
        </form>
        </div>
    </body>
</html>