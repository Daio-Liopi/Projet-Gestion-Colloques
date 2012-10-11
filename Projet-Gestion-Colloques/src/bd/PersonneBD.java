/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import metier.Membre;
import metier.Personne;
import metier.President;

/**
 *
 * @author Piwee
 */
public class PersonneBD extends Bd {

    public PersonneBD() throws Exception {
    }

    public Personne getProfil(String login, String mp) throws Exception {
        Personne result = null;

        /*----- Espace de requête  -----*/
        PreparedStatement st;

        /*----- Requête SQL -----*/
        String sql = "SELECT nomP, prenomP, courrielP, institutionP, statutP FROM Personne where loginp = '" + login + "' and mpp = '" + mp +"'";

        /*----- Ouverture de l'espace de requête -----*/
        try {
            st = this.cx.prepareStatement(sql);
        } catch (SQLException ex) {
            throw new Exception("Problème d'ouverture de l'espace de requête lors de la lecture des messages - " + ex.getMessage());
        }

        /*----- Interrogation de la base -----*/
        try {
            /*----- Exécution de la requête -----*/
            ResultSet rs = st.executeQuery();

            /*----- Lecture du contenu du ResultSet -----*/

            while (rs.next()) {
                switch (rs.getInt(5)) {
                    case Personne._PRESIDENT:
                        result = new President(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), login, mp);
                        break;
                    case Personne._MEMBRE:
                        result = new Membre(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), login, mp);
                        break;
                    default:
                        result = new Personne(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), login, mp);
                }

            }
        } catch (SQLException ex) {
            throw new Exception("Problème de lecture de la Persoone - " + ex.getMessage());
        }

        return result;
    }
}
