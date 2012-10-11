/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.*;

/**
 *
 * @author Piwee
 */
public class ColloqueBD extends Bd{

    public ColloqueBD() throws Exception {
        super();
    }
    
    public List<colloque> getListe() throws Exception{
       List<colloque> colloques = new ArrayList<colloque> ();
        /*----- Espace de requête  -----*/
        PreparedStatement st;

        /*----- Requête SQL -----*/
        String sql = "SELECT c.titrec, c.descriptionc, c.statutc, c.idc FROM colloque c ";

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
                colloques.add(new colloque(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
            }
        } catch (SQLException ex) {
            throw new Exception("Problème de lecture du colloque - " + ex.getMessage());
        }
        
        return colloques;
    }
}
