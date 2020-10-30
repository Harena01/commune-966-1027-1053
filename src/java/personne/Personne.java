/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package personne;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashSet;
import modele.BaseModele;
import utils.Helper;
/**
 *
 * @author ONINTSOA
 */
public class Personne extends BaseModele {
     private String nom;
    private String prenom;
    private String sexe;

	public Personne(){}
    public Personne(int id, String nom, String prenom) {
        this.setId(id);
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    public Personne(int id, String nom, String prenom, String sexe) {
        this.setId(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setSexe(sexe);
    }
    
      public Personne(String nom, String prenom, String sexe) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setSexe(sexe);
    }
	public Personne(int id){
		this.setId(id);
	}
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }   
    
    public Personne[] findByGenre(char genre,Connection connection) throws Exception{
        Personne[] personne = null;
        ResultSet rs = null;
        try{
            String sql = "select id,prenom,nom from personne where sexe='%c'";
            sql = String.format(sql,genre);
            rs = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
            int i=0;
            rs.last();
            personne = new Personne[rs.getRow()];
            rs.beforeFirst();
			while(rs.next()){
                    personne[i] = new Personne(rs.getInt(1), rs.getString(2), rs.getString(3) );
					System.out.print("ici huhu");
                    i++; 
                }
            return personne;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }finally{
            if(rs != null)rs.close();
        }
    }
    public Object[] find(Connection connection) throws Exception{
        Object[] personne =null;
        ResultSet rs = null;
        try{
            String sql="select * from personne";
            rs=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
            int i=0;
            rs.last();
            personne =  new Personne[rs.getRow()];
            rs.beforeFirst();
                while(rs.next()){
                    personne[i] = new Personne( rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4) );
                    i++; 
                }
        return personne;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }finally{
            if(rs != null)rs.close();
        }
    }
    @Override
    public Object[] find() throws Exception{
        Object[] personne = null;
        Connection connection=Helper.getConnection();
        try{
            personne = this.find(connection);
            return personne;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }finally{
            if(connection != null)connection.close();  
        }
    }
     @Override
    public void save() throws Exception{}
    
    @Override
    public void update() throws Exception{}
    
    @Override
    public void remove() throws Exception{}
    
    @Override
    public Object findById() throws Exception{return new Object();}
}
