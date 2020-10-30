package etu966_harena ;
import modele.BaseModele;

public class Personne extends BaseModele {
    private int id;
    private String nom;
    private String prenom;
    private String sexe;

    public String getNom() {
        return name;
    }
 
    public void setNom(String name) {
        this.name = name;
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
    
}
