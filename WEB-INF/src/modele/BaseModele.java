/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author ITU
 */
public abstract class BaseModele {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public abstract void save()throws Exception; 
    
    public abstract Object[] find() throws Exception;
    
    public abstract void update() throws Exception;
    
    public abstract void remove() throws Exception; 
    
}
