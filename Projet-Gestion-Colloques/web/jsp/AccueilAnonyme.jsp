<%-- 
    Document   : newjsp
    Created on : 7 oct. 2012, 14:10:12
    Author     : Piwee
--%>

<%@page import="manager.ColloqueManager"%>
<%@page import="java.util.List"%>
<%@page import="metier.colloque"%>
<%@page import="bd.ColloqueBD"%>
<%@page import="bd.Bd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div ><h3><a href="connexionAppli">se connecter</a> </h3> </div>
        <div>
            <h1>Gestionnaire de Colloque</h1>

            <p>liste des colloques </p>

            <!-- récupération et affichage de la liste  -->

            <%
                //connexion à la base
                //ColloqueBD connexion = new ColloqueBD();

                //récupération de la liste
                //List<colloque> lColloques = connexion.getListe();
                List<colloque> lColloques = ColloqueManager.getAllColloque();

                //affichage de la liste pour renvoyer sur la page du colloque
                    out.println("<table border=\"1\" cellspacing=\"0\" cellpadding=\"5\">");
                    out.println("<tr><th>Colloque</th></tr>");
                    for (int i=0; i<lColloques.size(); i++)
                                            {

                        out.println("<tr><td>" + "<a href=\"ThemeColloque?id="+lColloques.get(i).getIdC() +"\">"+ i+"</a>" + "</td></tr>");
                                            }

                    out.println("</table>");

            %>
        </div>
    </body>
</html>
