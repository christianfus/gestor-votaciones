<jsp:useBean id="opc" class="Classes.Opcions" scope="session"/>
<%
    
    String seleccio=request.getParameter("equip");
    opc.votarEquip(seleccio);
    response.sendRedirect("Votacions.jsp");

      
%>
