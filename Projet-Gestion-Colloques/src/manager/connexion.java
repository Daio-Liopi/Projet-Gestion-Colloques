/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Membre;
import metier.Personne;
import metier.President;

/**
 *
 * @author Piwee
 */
public class connexion extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*----- Vérification des paramètres saisis par l'utilisateur -----*/
            String Login = request.getParameter("login");
            String Password = request.getParameter("mp");

            // Astuce pour vérifier si l'utilisateur a renseigné du texte

            String msg = "";
            if(Login != null && Password != null){
                if (Login.equals("") && Password.equals("")) {
                    msg = "Veuillez saisir les informations demandées";
                } else if (Login.equals("")) {
                    msg = "Veuillez saisir votre identifiant";
                } else if (Password.equals("")) {
                    msg = "Veuillez saisir votre mot de passe";
                }
            }
            //problème lors de la saisie    
            if (!msg.equals("")) {
                // permet de déléguer la suite à faire
                RequestDispatcher rd = request.getRequestDispatcher("connexionAppli");
                // Retour à la page initiale + message d'erreur vu par l'utilisateur
                request.setAttribute("msg_erreur", msg);

                // Ces deux lignes permet de remettre le pseudo après une erreur de saisie
                // quand l'utilisateur revient sur la page formulaire
                // en fait il y a une requete envoyée au serveur

                if (!Login.equals("")) {
                    request.setAttribute("login", Login);
                }
                if (!Password.equals("")) {
                    request.setAttribute("password", Password);
                }

                rd.forward(request, response);
            } else {
                try {
                    //Saisie ok

                    //vérification des identifiants dans la base

                    Personne User = ConnexionManager.getUserByLogin(Login, Password);


                    //si NOK retour a connexionAppli
                    if (User == null) {
                        // permet de déléguer la suite à faire
                        RequestDispatcher rd = request.getRequestDispatcher("connexionAppli");
                        // Retour à la page initiale + message d'erreur vu par l'utilisateur
                        request.setAttribute("msg_erreur", "Identifiant ou mot de passe incorrect");

                        //renvoyer le login password pour éviter la resaisie
                        if (!Login.equals("")) {
                            request.setAttribute("login", Login);
                        }
                        if (!Password.equals("")) {
                            request.setAttribute("password", Password);
                        }
                        rd.forward(request, response);
                    } else {
                        //si OK
                        //mise en session de l'utilisateur
                        request.getSession(true).setAttribute("user", User);

                        //redirection vers la page du profil utilisateur
                        String pageDeRedirection = "AccueilInvite";
                     
                        
                        if (User.getClass().equals(President.class)) {
                            pageDeRedirection = "AccueilPresident";

                        }
                        if (User.getClass().equals(Membre.class)) {
                            pageDeRedirection = "AccueilMembre";

                        }
                        

                        RequestDispatcher rd = request.getRequestDispatcher(pageDeRedirection);
                        rd.forward(request, response);
                    }
                } catch (Exception ex) {
                    // permet de déléguer la suite à faire
                RequestDispatcher rd = request.getRequestDispatcher("connexionAppli");
                // Retour à la page initiale + message d'erreur vu par l'utilisateur
                request.setAttribute("msg_erreur", ex.getMessage());
                
                 rd.forward(request, response);
                }

            }

        }
        catch (Exception ex){
             new Exception(" " + ex.getMessage());
        } 
        
finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
