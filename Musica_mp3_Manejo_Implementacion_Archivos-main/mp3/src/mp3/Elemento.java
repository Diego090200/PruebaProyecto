/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3;

/**
 *
 * @author Daniel
 */
public class Elemento {
    private String valor;
    private Elemento siguiente;
    
    public Elemento(String dato){
        this.valor = dato;
        this.siguiente = null;
    }
    
    public String getvalor(){
        return valor;
    }
    
    
    public Elemento getsiguiente(){
        return siguiente;
    }
    
     public void setsiguiente(Elemento elemento){
        siguiente = elemento;
    }
}


