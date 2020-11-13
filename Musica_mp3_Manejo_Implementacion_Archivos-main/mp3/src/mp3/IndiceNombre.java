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
public class IndiceNombre {
    private short posicion;
    private String NombreCancion;

    public IndiceNombre(short posicion, String nombre) {
        this.posicion = posicion;
        this.NombreCancion = nombre;
    }
    
    public short getPosicion() {
        return posicion;
    }

    public String NombreCancion() {
        return NombreCancion;
    }

    public void setPosicion(short posicion) {
        this.posicion = posicion;
    }

    public void SetNombreCancion(String nombre) {
        this.NombreCancion = nombre;
    }
}


