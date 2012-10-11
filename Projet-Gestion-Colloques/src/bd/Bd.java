package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe
 */
public class Bd
{
	/*----- Données -----*/
	protected Connection cx;

	/*----- Données de connexion -----*/
        private String url ="jdbc:oracle:thin:@80.13.174.165:1521/xe";
	private String login = "projetdai";
	private String password = "projetdai";

	/*----- Constructeur -----*/
    public Bd () throws Exception
		{
		/*----- Chargement du pilote pour la BD -----*/
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			}
		catch (ClassNotFoundException ex)
			{
			throw new Exception("Pilote pour se connecter à Oracle introuvable - " + ex.getMessage());
			}

		/*----- Ouverture de la connexion -----*/
		try {
			this.cx = DriverManager.getConnection(url,login,password);
			}
		catch (SQLException ex)
			{
			throw new Exception("Problème de connexion à la base - " + ex.getMessage());
			}
		}
	

}