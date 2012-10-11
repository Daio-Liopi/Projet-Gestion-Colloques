package metier;

/**************************************************************************
* Source File	:  colloque.java
* Author                   :  LACOSTE  
* Project name         :  Non enregistr�* Created                 :  29/09/2012
* Modified   	:  29/09/2012
* Description	:  Definition of the class colloque
**************************************************************************/


public  class colloque  
{ 

	//Attributes
        private int idC;
	private  String titreC;
	private  String descriptionsC;
	private  String statutC;
	
	//Attributes Association
        Expose Asso_1[];
        Motcles theme[];
        Expose programme[];
        President preside;
        Membre fairePartieDuComite[];

                
    public colloque(String titreC, String descriptionsC, String statutC,int idC) {
        this.idC = idC;
        this.titreC = titreC;
        this.descriptionsC = descriptionsC;
        this.statutC = statutC;
    }
    
    public int getIdC() {
        return idC;
    }
    public String getTitreC() {
        return titreC;
    }

    public String getDescriptionsC() {
        return descriptionsC;
    }

    public String getStatutC() {
        return statutC;
    }

    public Expose[] getAsso_1() {
        return Asso_1;
    }

    public Motcles[] getTheme() {
        return theme;
    }

    public Expose[] getProgramme() {
        return programme;
    }

    public President getPreside() {
        return preside;
    }

    public Membre[] getFairePartieDuComite() {
        return fairePartieDuComite;
    }
	 
	
	
	
	

	
	//Operations
	
	public 
	 void InscrireExpose()
		{
	
	   		// TODO: implement
	
		}
	
		
	
	

} //End Class colloque


