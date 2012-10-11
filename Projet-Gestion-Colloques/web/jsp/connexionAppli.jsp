<%-- 
    Document   : connexionAppli
    Created on : 7 oct. 2012, 16:29:39
    Author     : Piwee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentification utilisateur</title>
    </head>
    <body>
        <h1>Connexion</h1>
          <%
			String msg_erreur = (String)request.getAttribute("msg_erreur");

			String login = (String)request.getAttribute("login");
			String password = (String)request.getAttribute("password");
        %>
        
        <form id="form1" name="form1" method="post" action="connexion">
            <label for="login">Identifiant</label>
            <input type="text" name="login" id="login" value="<%= (login==null) ? "" : login %>"/>
            <br />
            <label for="mp">Mot de passe : </label>
            <input type="text" name="mp" id="mp" value="<%= (password==null) ? "" : password %>"/>
            <input type="submit" name="btn_Connexion" id="btn_Connexion" value="Envoyer" />
      </form>
            
    
       <%//message si erreur de saisie
			if (msg_erreur != null)
				out.println("<p class=\"msg_erreur\">" + msg_erreur + "</p>");
        %>  
        
    </body>
</html>
