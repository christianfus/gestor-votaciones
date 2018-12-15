<%-- 
    Document   : mostra
    Created on : 30-nov-2018, 16:24:25
    Author     : fidel
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Classes.Opcions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pàgina principal</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <div>
        <jsp:useBean id="usu" class="Classes.Usuari" scope="session"/>
        <jsp:useBean id="opt" class="Classes.Opcions" scope="session"/>
        <h2 style="text-decoration: underline;">RECOMPTE</h2>
        <% 
            Opcions opc = new Opcions();
            ArrayList<Opcions> llista = opc.instanciarOpcions();
            
            for (Opcions opcion : llista) {
        %>
        <h2><%=opcion.getText()%>: <%=opcion.getHavotat()%></h2>
        <%        
            }
        %>
        
        
        </div>   
    </body>
</html>

