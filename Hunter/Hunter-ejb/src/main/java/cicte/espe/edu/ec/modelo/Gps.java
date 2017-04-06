/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cicte.espe.edu.ec.modelo;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author esteb
 */
@Entity(value = "Gps", noClassnameStored = true)
public class Gps 
{
    private static final long serialVersionUID = 1L;
    @Id
    private double longitud;
    private double latitud;

    public Gps() {
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
    
    
}