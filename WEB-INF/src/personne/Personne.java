/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personne;
import modele.BaseModele;

/**
 *
 * @author ITU
 */
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
