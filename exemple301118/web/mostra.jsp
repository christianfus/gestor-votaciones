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
    
        <jsp:useBean id="usu" class="Classes.Usuari" scope="session"/>
        <jsp:useBean id="enq" class="Classes.Enquesta" scope="session"/>
        <jsp:useBean id="opt" class="Classes.Opcions" scope="session"/>
        
        <% enq.existeTot(); %>
        
        
        
        
        <div>
        <h2><jsp:getProperty name="enq" property="text"/></h2>
        <form action="valida03.jsp" method="POST">
        <% 
            opt.instanciarOpcions();
            
            Opcions opc = new Opcions();
            ArrayList<Opcions> llista = opc.instanciarOpcions();
            
             for (Opcions opcion : llista) { 
                if(opcion.getIdOpcio() == 1L) {
            %>   
                <input checked type="radio" name="equip" value="<%=opcion.getIdOpcio()%>"> <%=opcion.getText()%> <br>            
            <%   
                } else {
            %>   
            <input type="radio" name="equip" value="<%=opcion.getIdOpcio()%>"> <%=opcion.getText()%> <br>      
            <% }
            }
            %> 
            <br><input type="submit" name="button" value="Enviar resposta"><br><p></p>
            
            <%
            //opc.equipsFutbol(); 
            /*
            Opcions opcio = new Opcions();
            opcio.setEquips(opcio.getEquips());
            
            for(int i=0;i<opcio.getEquips().size();i++){
                
            } */     
        %>
        </form>
        </div>
        
        
    </body>
</html>
