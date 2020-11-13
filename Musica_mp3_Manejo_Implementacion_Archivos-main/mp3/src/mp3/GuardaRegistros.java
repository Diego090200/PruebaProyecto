/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alehe
 */
public class GuardaRegistros {
    private String nombreDeArchivo;
    private ArrayList<MP3> listadoRegistros;
    private ArrayList<IndiceNombre> indiceRegistros;

    public GuardaRegistros() {
        this.listadoRegistros = new ArrayList<>();
        this.indiceRegistros = new ArrayList<>();
    }
    
    public void agregarCancion(MP3 cancion, String apellido){
        this.listadoRegistros.add(cancion);
        this.indiceRegistros.add(new IndiceNombre((short)0, apellido));
    }
    
    public void guardar() throws IOException{
        new FileOutputStream("canciones.data").close();//Limpio el archivo antes de insertar
        try {    
            RandomAccessFile archivo = new RandomAccessFile("canciones.data", "rw");
            short punteroAIndice = 0;
            archivo.writeShort(punteroAIndice);
            int contadorIndice = 0;
            for(MP3 cancion : listadoRegistros){try {//recorre el array
                indiceRegistros.get(contadorIndice++).setPosicion((short)archivo.getFilePointer());//se incrementa despues de hacer esa linea
                //archivo.getFilePointer(); //en que posicion está escribiendo
                archivo.write(cancion.getNombre_artista().length());//es un byte
                archivo.writeChars(cancion.getNombre_artista());
                System.out.println("Longtitud de " + cancion.getNombre_artista() + " ES " + cancion.getNombre_artista().length());
                archivo.write(cancion.getNombre_album().length());
                archivo.writeChars(cancion.getNombre_album());
                
                archivo.write(cancion.getFecha_album().length());
                archivo.writeChars(cancion.getFecha_album());
                
                archivo.write(cancion.getGenero().length());
                archivo.writeChars(cancion.getGenero());
                
                archivo.write(cancion.getDuracion().length());
                archivo.writeChars(cancion.getDuracion());
                
                archivo.write(cancion.getURL().length());
                archivo.writeChars(cancion.getURL());
                
                archivo.write(cancion.getDireccion_pista().length());
                archivo.writeChars(cancion.getDireccion_pista());
                System.out.println(cancion.getDireccion_pista());
                                System.out.println("LONG " + cancion.getDireccion_letra().length());
                archivo.write(cancion.getDireccion_letra().length());
                archivo.writeChars(cancion.getDireccion_letra());
                } catch (IOException ex) {
                    Logger.getLogger(GuardaRegistros.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            punteroAIndice = (short)archivo.getFilePointer();
            for (int i = 0; i < indiceRegistros.size(); i++) //Organizamos el arreglo del indice
            {
                for (int j = i + 1; j < indiceRegistros.size(); j++) 
                {
                    if (indiceRegistros.get(i).NombreCancion().compareTo(indiceRegistros.get(j).NombreCancion()) > 0) 
                    {
                        String temp = indiceRegistros.get(i).NombreCancion();
                        indiceRegistros.get(i).SetNombreCancion(indiceRegistros.get(j).NombreCancion());
                        indiceRegistros.get(j).SetNombreCancion(temp);
                        
                        short temp1 = indiceRegistros.get(i).getPosicion();
                        indiceRegistros.get(i).setPosicion(indiceRegistros.get(j).getPosicion());
                        indiceRegistros.get(j).setPosicion(temp1);
                    }
                }
            }
            
            for(IndiceNombre indice: indiceRegistros){
                    archivo.writeShort(indice.getPosicion());
                    archivo.writeByte(indice.NombreCancion().length());
                    archivo.writeChars(indice.NombreCancion()); 
            }
            archivo.seek(0);//regreso a la posición 0
            archivo.writeShort(punteroAIndice);
            try {
                archivo.close();
            } catch (IOException ex) {
                Logger.getLogger(GuardaRegistros.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GuardaRegistros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setNombreDeArchivo(String nombreDeArchivo) {
        this.nombreDeArchivo = nombreDeArchivo;
    }

    public void setListadoRegistros(ArrayList<MP3> listadoRegistros) {
        this.listadoRegistros = listadoRegistros;
    }

    public void setIndiceRegistros(ArrayList<IndiceNombre> indiceRegistros) {
        this.indiceRegistros = indiceRegistros;
    }

    public String getNombreDeArchivo() {
        return nombreDeArchivo;
    }

    public ArrayList<MP3> getListadoRegistros() {
        return listadoRegistros;
    }

    public ArrayList<IndiceNombre> getIndiceRegistros() {
        return indiceRegistros;
    }
    
}
