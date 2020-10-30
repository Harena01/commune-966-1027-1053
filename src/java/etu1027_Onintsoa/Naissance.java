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
 * @author ITU
 */
public class Naissance extends BaseModele{
     private String nom;
    private Personne pere;
    private Personne mere;
    private String lieu;
    private Calendar dateNaissance;
    
    public Personne getPere() {
        return pere;
    }

    public void setPere(Personne pere) {
        this.pere = pere;
    }

    public Personne getMere() {
        return mere;
    }

    public void setMere(Personne mere) {
        this.mere = mere;
    }
    public String getNom() {
        return nom;
    }

    public void setName(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Calendar getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Calendar dateNaissance) {
        this.dateNaissance = dateNaissance;
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
            pst = connection.prepareStatement("INSERT INTO naissance(nom,dateNaissance,lieu,idPere,idMere) VALUES (?,?,?,?,?)");
            pst.setString(1,getNom());
            pst.setString(2, dateNaissanceToString() );
            pst.setString(3, getLieu());
            pst.setInt(4, getPere().getId() );
            pst.setInt(5, getMere().getId() );
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
    public Naissance[] find() throws Exception{
        
        Naissance[] n = new Naissance[0];
    return n;
    }
     @Override
    public void update() throws Exception{
        Connection connection = null;
        PreparedStatement pst = null;
        try{
            connection=Helper.getConnection();
            connection.setAutoCommit(false);
            pst = connection.prepareStatement("UPDATE FROM naissance SET  nom=?,dateNaissance=?,lieu=?,idPere=?,idMere=? WHERE id=?");
            pst.setString(1,getNom());
            pst.setString(2, dateNaissanceToString() );
            pst.setString(3, getLieu());
            pst.setInt(4, getPere().getId() );
            pst.setInt(5, getMere().getId() );
            pst.setInt(6,getId());
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
    Connection connection=null;
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
