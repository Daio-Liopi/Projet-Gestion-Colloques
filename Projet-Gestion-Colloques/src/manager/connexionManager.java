/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import bd.PersonneBD;
import metier.Personne;

/**
 *
 * @author Piwee
 */
public class connexionManager {

    static Personne getUserByLogin(String Login, String Password) throws Exception {
        Personne result = null;
        
        PersonneBD lConnexion = new PersonneBD();
        result = lConnexion.getProfil(Login, Password);
        
        
        return result;
    }

    
    
    
    
}