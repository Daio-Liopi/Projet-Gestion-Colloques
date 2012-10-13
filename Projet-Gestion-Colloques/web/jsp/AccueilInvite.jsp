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
        <link href="/css/menu_HCouleur.css" rel="stylesheet" type="text/css">
        <link href="/css/cssStructure.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Bienvenue sur Gest_Colloque_2012</title>
    </head>
    <body>
        <div id='blocGeneral' align="center">
            <div id='blocLogo'>
                <img src="../images/logo_fr.png" width="96" height="96" alt="logo_ut1">
            </div>
            <div id='blocMenu'>
                <div id='cssmenu'>
                    <ul>
                        <li class='active'><a href='#'><span>Gestionnaire de Colloque</span></a></li>
                        <li><a href='#'><span>Liste des Colloques</span></a></li>
                        <li><a href='#'><span>Liste des Exposés déposés</span></a></li>
                        <li><a href='#'><span>Participer à un colloque</span></a></li>
                        <li><a href='#'><span>Contact</span></a></li>
                    </ul>
                </div>  
            </div>



            <div id='blocidentifiant'>



                <table width="290" height="71" border="0" cellspacing="5">
                    <tr>
                        <td width="34%">Bienvenue Se déconnecter</a></td>
                    </tr>
                    <tr>
                        <td width="34%"><a href='connexionAppli'>Se déconnecter</a></td>
                    </tr>
                </table>




            </div>
            <div id='blocBody'>
                <p>Page invitée </p>

                <!-- récupération et affichage de la liste  -->

                <%--
                    //connexion à la base
                    //ColloqueBD connexion = new ColloqueBD();

                    //récupération de la liste
                    //List<colloque> lColloques = connexion.getListe();
                    List<colloque> lColloques = ColloqueManager.getAllColloque();

                    //affichage de la liste pour renvoyer sur la page du colloque
                    out.println("<table>");
                    for (int i = 0; i < lColloques.size(); i++) {

                        out.println("<tr><td>" + lColloques.get(i).getTitreC() + "</td>");
                        out.println("<td>" + lColloques.get(i).getDescriptionsC() + "</td>");
                        out.println("<td>" + "<a href=\"ThemeColloque?id=" + lColloques.get(i).getIdC() + "\">Information</a>" + "</td>");
                        out.println("</tr>");

                    }
                    out.println("</table>");

                --%>
            </div>
            <div id='blocFooter'>
            </div>
        </div>
    </body>
</html>
