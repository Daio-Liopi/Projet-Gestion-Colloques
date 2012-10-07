/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import bd.ColloqueBD;
import java.util.List;
import metier.colloque;

/**
 *
 * @author Piwee
 */
public class ColloqueManager {
    
    //attributs
    private static List<colloque> lColloqueList = null;
    
    
    //méthodes
    public static List<colloque> getAllColloque() throws Exception{
        
        //vérification que la liste ne soit pas déjà récupérée
        if (lColloqueList == null){
            ColloqueBD connexion = new ColloqueBD();
            lColloqueList = connexion.getListe() ;
        }
        
        return lColloqueList;
    }
    
}
