/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cicte.espe.edu.ec.servicios;

import cicte.espe.edu.ec.dao.GpsDAO;
import cicte.espe.edu.ec.modelo.Gps;
import com.mongo.persistance.MongoPersistence;
import java.util.List;

/**
 *
 * @author esteb
 */
public class GpsServicio extends MongoPersistence {

    MongoPersistence mongo;

    GpsDAO gpsDAO;

    public GpsServicio() {
        this.mongo = new MongoPersistence();
        this.gpsDAO = new GpsDAO(mongo.context());
    }

    public String Insert(Gps gps) {
        return this.gpsDAO.insert(gps);
    }

    /*public Boolean UpdateNombre(Gps gps) {
        return this.gpsDAO.updateNombreGps(gps);
    }

    public void Delete(Gps gps) {
        this.gpsDAO.deleteGps(gps);
    }*/

    public List<Gps> ObtenerLista() {
        return this.gpsDAO.getGpss();
    }

}
