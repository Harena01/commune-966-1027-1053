/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etu1027_Onintsoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import personne.Personne;
import modele.BaseModele;
import utils.Helper;
/**
 *
 * @author ONINTSOA
 */
public class Naissance extends BaseModele{
     private Personne nouveau;
    private Personne pere;
    private Personne mere;
    private String lieu;
    private String dateNaissance;
    
	public Naissance(){}
    public Naissance(int id,String nom, String prenom, String sexe, int idP, String nomP, String prenomP, int idM, String nomM, String prenomM, String lieu, String date ){
        this.setId(id);
		this.setNouveau(nom, prenom, sexe);
        this.setPere(idP, nomP, prenomP);
        this.setMere(idM, nomM, prenomM);
        this.setLieu(lieu);
        this.setDateNaissance(date);
    }
	public Naissance(String nom, String prenom, String sexe, int idP, int idM, String lieu, String date){
		this.setNouveau( nom, prenom, sexe);
        this.setPere(idP);
        this.setMere(idM);
        this.setLieu(lieu);
        this.setDateNaissance(date);
	}
    
	public Personne getPere() {
        return pere;
    }

	public void setPere(int idp) {
        this.pere = new Personne(idp);
    }
	
	public void setMere(int idp) {
        this.pere = new Personne(idp);
    }
    public void setPere(int idp, String nom, String prenom) {
        this.pere = new Personne(idp, nom, prenom);
    }

    public Personne getMere() {
        return mere;
    }

    public void setMere(int idm, String nom, String prenom) {
        this.mere = new Personne (idm, nom, prenom);
    }
     
     public void setNouveau(String nom, String prenom, String sexe){
             this.nouveau = new Personne(nom, prenom, sexe);
    }

     public Personne getNouveau(){
         return this.nouveau;
     }
    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }
    
     public void setDateNaissance(String dateNaissance) {
        
    }
    private String dateNaissanceToString(){
        String result="";
        return result;
    }
     @Override
    public void save() throws Exception{
        Connection connection = null;
        PreparedStatement pst = null;
        try{
            connection=Helper.getConnection();
            connection.setAutoCommit(false);
            pst = connection.prepareStatement("INSERT INTO naissance(nom,prenom,sexe,dateNaissance,lieu,idPere,idMere) VALUES (?,?,?,?,?)");
            pst.setString(1,getNouveau().getNom() );
            pst.setString(2,getNouveau().getPrenom() );
            pst.setString(3,getNouveau().getSexe() );
            pst.setString(4, getDateNaissance() );
            pst.setString(5, getLieu() );
            pst.setInt(6, getPere().getId() );
            pst.setInt(7, getMere().getId() );
            pst.executeUpdate();
            connection.commit();
        }catch(Exception ex){   
            connection.rollback();
            throw ex;
        }finally{
            if(pst != null)pst.close();
            if(connection != null)connection.close();            
        }     

    }   
    @Override
    public Object[] find() throws Exception{
        Object[] naissance = null;
        Connection connection=Helper.getConnection();
         ResultSet rs = null;
        try{
            String sql="select * from all_naissance";
           rs = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
            int i=0;
            rs.last();
            naissance=new Naissance[rs.getRow()];
            rs.beforeFirst();
                while(rs.next()){
                    naissance[i] = new Naissance( rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12) );
                    i++; 
                }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }finally{
            rs.close();
            connection.close();   
        }
    return naissance;
    }
    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
   public Object findById() throws Exception{
        Object naissance = null;
        Connection connection = Helper.getConnection();
        ResultSet rs = null;
        try{
            String sql = "select * from all_naissance where id=%i";
            sql = String.format(sql,getId());
            rs = connection.createStatement().executeQuery(sql);
            if(rs.next()){
                naissance = new Naissance(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12) );
            }
        }catch(Exception e){
            
        }finally{
			if(rs != null)rs.close();
            if(connection != null)connection.close();  
        }
        return naissance;
    }
     @Override
    public void update() throws Exception{
        Connection connection = null;
        PreparedStatement pst = null;
        try{
            connection=Helper.getConnection();
            connection.setAutoCommit(false);
            pst = connection.prepareStatement("UPDATE FROM naissance SET  nom=?,prenom=?, sexe=?, dateNaissance=?, lieu=?, idPere=?, idMere=? WHERE id=?");            
            pst.setString(1, getNouveau().getNom() );
            pst.setString(2, getNouveau().getPrenom() );
            pst.setString(3, getNouveau().getSexe() );
            pst.setString(4, dateNaissanceToString() );
            pst.setString(5, getLieu() );
            pst.setInt(6, getPere().getId() );
            pst.setInt(7, getMere().getId() );
            pst.setInt(8,getId());
            pst.executeUpdate();
            connection.commit();
        }catch(Exception ex){   
            connection.rollback();
            throw ex;
        }finally{
            if(pst != null)pst.close();
            if(connection != null)connection.close();            
        }     
    }
    
     @Override
    public void remove()throws Exception{
    Connection connection=Helper.getConnection();
        PreparedStatement pst=null;
        try{
            connection=Helper.getConnection();
            connection.setAutoCommit(false);
            pst = connection.prepareStatement("DELETE FROM naissance WHERE id=?");
            pst.setInt(1,getId());
            pst.executeUpdate();
            connection.commit();
        }catch(Exception ex){   
            connection.rollback();
            throw ex;
        }finally{
            if(pst!=null)pst.close();
            if(connection!=null)connection.close();            
        }     
    }
}
