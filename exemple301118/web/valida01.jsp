<%
   String nomboto=request.getParameter("boto");
   if(nomboto.equals("Registre")) {
       RequestDispatcher rd=request.getRequestDispatcher("registre.jsp");
       rd.forward(request,response);
   }
   else {
      
%>

<jsp:useBean id="usu" scope="session" class="Classes.Usuari"/>

<jsp:setProperty name="usu" property="*"/>

<% if(usu.isValid()) {
     if(usu.noHaVotat()) {
        usu.votar();
        response.sendRedirect("mostra.jsp");
     }
     else {
       session.invalidate();
       response.sendRedirect("Votacions.jsp");
     }
}
else {
     session.invalidate();
     response.sendRedirect("error.html"); 
}
}
%>