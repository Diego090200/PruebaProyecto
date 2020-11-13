/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alehe
 */
public class Guardar {
     //Para esta clase se utilizaron conceptos aprendidos en clase, con una base en un ejercicio realizado.
    //Se crean los elementos necesarios como vistos en clase.    
    private String nombreDeArchivo;
    
    private ArrayList<Canciones> ListaRegistros;
    
    private ArrayList<IndiceCanciones> IndiceRegistros;
    
    public Guardar(String nombreDeArchivo) {
        this.nombreDeArchivo = nombreDeArchivo;
        this.ListaRegistros = new ArrayList<>();
        this.IndiceRegistros = new ArrayList<>();
        
        
    }
    
    
    
    public ArrayList getCanciones(){
       ListaRegistros = new ArrayList<Canciones>();
       return ListaRegistros;
    }
    
    
    public ArrayList getIndCan(){
       IndiceRegistros = new ArrayList<IndiceCanciones>();
       return IndiceRegistros;
    }
    
    
    public void agregarCancion(Canciones cancion, String nombreC){
        this.ListaRegistros.add(cancion);
        this.IndiceRegistros.add(new IndiceCanciones(nombreC,0));
    }
    
    
    
    public void guardar(){
        try {            
            RandomAccessFile archivo = new RandomAccessFile(nombreDeArchivo,"rw");
            archivo.seek(2);
            int punteroAIndice = 0; 
            
            archivo.writeShort(punteroAIndice);
            
            int contadorIndice = 0;
            for(Canciones cancion : ListaRegistros){
                IndiceRegistros.get(contadorIndice++).setPosicion((int)archivo.getFilePointer());
                
                archivo.write(cancion.getDisquera().length());
                archivo.writeBytes(cancion.getDisquera());
                
                archivo.write(cancion.getArtista().length());
                archivo.writeBytes(cancion.getArtista());
                
                archivo.write(cancion.getAlbum().length());
                archivo.writeBytes(cancion.getAlbum());     
                
                archivo.write(cancion.getAño().length());
                archivo.writeBytes(cancion.getAño());   
                
                archivo.write(cancion.getNombreC().length());
                archivo.writeBytes(cancion.getNombreC());   
                
                archivo.write(cancion.getGenero().length());
                archivo.writeBytes(cancion.getGenero());   
                
                archivo.write(cancion.getDireccionC().length());
                archivo.writeBytes(cancion.getDireccionC());   
                
                archivo.write(cancion.getUrlAutor().length());
                archivo.writeBytes(cancion.getUrlAutor());   
                
                archivo.write(cancion.getUrlDisquera().length());
                archivo.writeBytes(cancion.getUrlDisquera());   
                
                archivo.write(cancion.getBiografia().length());
                archivo.writeBytes(cancion.getBiografia());   
            
            }

            punteroAIndice = (int)archivo.getFilePointer();
            
            for(IndiceCanciones indice: IndiceRegistros){
                archivo.writeInt((int) indice.getPosicion());
                archivo.writeByte(indice.getNombreC().length());
                archivo.writeBytes(indice.getNombreC());
            }
            
            archivo.seek(0);
            archivo.writeInt(punteroAIndice);
            
            archivo.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Guardar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public String getNombreDeArchivo() {
        return nombreDeArchivo;
    }

    public void setNombreDeArchivo(String nombreDeArchivo) {
        this.nombreDeArchivo = nombreDeArchivo;
    }

    public ArrayList<Canciones> getListaRegistros() {
        return ListaRegistros;
    }

    public void setListaRegistros(ArrayList<Canciones> ListaRegistros) {
        this.ListaRegistros = ListaRegistros;
    }

    public ArrayList<IndiceCanciones> getIndiceRegistros() {
        return IndiceRegistros;
    }

    public void setIndiceRegistros(ArrayList<IndiceCanciones> IndiceRegistros) {
        this.IndiceRegistros = IndiceRegistros;
    }
}
