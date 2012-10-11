package metier;

/**************************************************************************
* Source File	:  Personne.java
* Author                   :  LACOSTE  
* Project name         :  Non enregistr�* Created                 :  29/09/2012
* Modified   	:  29/09/2012
* Description	:  Definition of the class Personne
**************************************************************************/



import java.util.*;



public  class Personne  
{ 
	//Inners Classifiers
	public static final int _PERSONNE = 0;
        public static final int _PRESIDENT = 1;
public static final int _MEMBRE = 2;
	//Attributes
		
		
	
		private 
	 String nom;
		private 
	 String prenom;
		private 
	 String courriel;
		private 
	 String institution;
		private 
	 String login;
		private 
	 String mp;
	
	//Attributes Association
	
		Expose Asso_1[];
	 
	
	
	
	

	
	//Operations

    public Personne(String nom, String prenom, String courriel, String institution, String login, String mp) {
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
        this.institution = institution;
        this.login = login;
        this.mp = mp;
    }
		
		
	
	

} //End Class Personne


