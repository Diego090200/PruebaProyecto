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
public class Pila {
    private Elemento tope;
    private int size;
    
    public Pila(){
        tope = null;
        size = 0;
    }
    
    public void insertar(String dato){
        Elemento elemento = new Elemento(dato);
        if (tope == null){
            tope = elemento;
            size ++;
        }
        else{
            Elemento aux = tope;
            elemento.setsiguiente(aux);
            size ++;
            tope = elemento;
        }
    }
    
    public int size(){
        return size;
    }       
    
    public Elemento tope(){
        return tope;
    }
    
    public String eliminar(){
        String Adevolver;
        if(tope != null){
            Adevolver = tope.getvalor();
            Elemento aux = tope;
            tope = aux.getsiguiente();
            aux.setsiguiente(null);
            size --;
        }else{
            Adevolver = "No hay datos";
        }
        return Adevolver;
    }        
    
    public Boolean buscar(String n){
        Boolean ver = false;
        Pila pilaux = new Pila();
        Elemento busqueda = tope;
        while(busqueda != null){
            if(busqueda.getvalor() == n){                
                ver = true;
                break;                
            }            
            pilaux.insertar(busqueda.getvalor());
            busqueda = busqueda.getsiguiente();            
            eliminar();             
        }
        Elemento aux = pilaux.tope(); 
        while(aux !=null){
            
            String x = aux.getvalor();
            insertar(x);
            aux = aux.getsiguiente();
        }
        return ver;
    }
    
    public void mostrar(){
        Elemento aux = this.tope;
        System.out.println("Tamaño " + size);
        for(int i =0; i < size; i++){
            System.out.println("Ruta " + aux.getvalor());
            if(aux.getsiguiente() == null){
                break;
            }
            aux = aux.getsiguiente();
        }
    }
    
    public boolean esta_vacia(){
        boolean vacia;
        if (tope == null){
            vacia=true;
            return vacia;
        }
        else{
            vacia = false;
            return vacia;
        }
    }
}


