package etu966_harena;


import java.sql.Connection;
import java.sql.PreparedStatement;
import utils.Helper; 
import modele.BaseModele;

public class Mariage extends BaseModele {
    private String nom;
    private String prenom;
    private String sexe;
    private Connection connection = null;

    public String getNom() {
        return nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void save (Connection connection) throws Exception{
        PreparedStatement pre = null;
        try {
            connection=Helper.getConnection();
            connection.setAutoCommit(false);
            pre = connection.prepareStatement("Update from mariage set nom=?,prenom=?,sexe=?");
            pre.setString(1, getNom());
            pre.setString(2, getPrenom());
            pre.setString(3,getSexe());
            pre.executeUpdate();
            connection.commit();
            pre.close();
        } catch (Exception e) {
            //TODO: handle exception
            connection.rollback();
            throw e;
        }
    }

    @Override
    public void save() throws Exception {
        save(connection);
        connection.close();
    }

    @Override
    public Mariage[] find() throws Exception {
        // TODO Auto-generated method stub
        Mariage[] valiny = new Mariage[0];
        return valiny;
    }

    @Override
    public void update() throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void remove() throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public Object findById() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
