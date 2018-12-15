<jsp:useBean id="usu" scope="session" class="Classes.Usuari"/>

<jsp:setProperty name="usu" property="*"/>

<% if(usu.isValidComplet()) {
     if(usu.existeLogin()) {
        session.invalidate();
        response.sendRedirect("error2.html");
     }
     else {
        int torna=usu.alta();
        if(torna==0) {
            session.invalidate();
            response.sendRedirect("index.html");
        } 
        else {
            session.invalidate();
            request.setAttribute("missatge","No s'ha pogut fer l'alta, error "+torna);
            RequestDispatcher rd=request.getRequestDispatcher("registre.jsp");
            rd.forward(request, response);
        }
     }
}
else {
     session.invalidate();
     response.sendRedirect("error3.html");
}
%>