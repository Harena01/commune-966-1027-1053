package etu966_harena ;
import java.util.ArrayList;

import modele.BaseModele;

public class Personne extends BaseModele {
    private int id;
    private String nom;
    private String prenom;
    private String sexe;

    public String getNom() {
        return nom;
    }
 
    public void setNom(String name) {
        this.nom = name;
    }

    public int getId(){
        return this.id;
    }

    public void setPrenom (String prenom){
        this.prenom = prenom;
    }

    public void setSexe(int sexe){
        if(sexe == 0)
            this.sexe = "femme";
        if (sexe == 1)
            this.sexe = "homme";
    }

    public String getPrenom(){
        return this.prenom;
    }

    public String getSexe(){
        return this.sexe;
    }

    public Personne[] findByGenre(String genre){
        Personne[] listPersonne=new Personne[0];
    return listPersonne;
    }
    @Override
    public void save() throws Exception{

    }
    
    @Override
    public void update() throws Exception{}
    
    @Override
    public void remove() throws Exception{}
    
    @Override
    public Object[] find() throws Exception{
        Object[] personne =new Personne[0];
    return personne;
    }

    public Personne(int id , String nom , String prenom , int sexe) {
        this.id = id;
        setNom(nom);
        setPrenom(prenom);
        setSexe(sexe);
    }

    public Personne (){}

    public static Personne[] array (ArrayList[] list,int size){
        Personne[] valiny = new Personne[size];
        for(int j = 0 ; j < size ; j++){
            int arg1 = (int) list[j].get(0);
            String arg2 = (String) list[j].get(1);
            String arg3 = (String) list[j].get(2);
            int arg4 =  (int) list[j].get(3); 
            valiny[j] = new Personne(arg1,arg2,arg3,arg4);
        }
        return valiny;
    }

    public static String[] getName (Personne[] data,String sexe){
        int count = data.length;
        ArrayList temp = new ArrayList<String>();
        for (int i = 0 ; i < count ; i++){
            if(data[i].getSexe()==sexe){
                temp.add(data[i].getNom()); 
            }
        }
        String[] valiny = (String[]) temp.toArray();
        return valiny;
    }

    public static int[] getId (Personne[] data,String sexe){
        int count = data.length;
        ArrayList temp = new ArrayList<Integer>();
        for (int i = 0 ; i < count ; i++){
            if(data[i].getSexe()==sexe){
                temp.add(data[i].getId()); 
            }
        }
        Integer[] temp1 = (Integer[]) temp.toArray();
        int[] valiny = new int[temp1.length];
        for(int i = 0 ; i < temp1.length ; i++)
            valiny[i] = temp1[i].intValue();

        return valiny;
    }

    @Override
    public Object findById() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
