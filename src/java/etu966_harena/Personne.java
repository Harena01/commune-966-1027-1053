package etu966_harena ;
import modele.BaseModele;

public class Personne extends BaseModele {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Personne[] findByGenre(String genre){
        Personne[] listPersonne=new Personne[0];
    return listPersonne;
    }
    @Override
    public void save() throws Exception{}
    
    @Override
    public void update() throws Exception{}
    
    @Override
    public void remove() throws Exception{}
    
    @Override
    public Object[] find() throws Exception{
        Object[] personne =new Personne[0];
    return personne;
    }
    
}
