
package cicte.espe.edu.ec.web;

import cicte.espe.edu.ec.modelo.Gps;
import cicte.espe.edu.ec.servicios.GpsServicio;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
  
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author esteb
 */
@ManagedBean
@ViewScoped
public class MarkerSelectionView implements Serializable {
    private MapModel simpleModel;
    private List<Gps> listGps;
    private Gps gps;
    private Marker marker;
    private GpsServicio gpsServicio=new GpsServicio();
    private static final Logger LOG = Logger.getLogger(MarkerSelectionView.class.getName());
    private List<String> coman=new ArrayList<String>(Arrays.asList("ERICK", "COMANDO", "DANIEL"));
    @PostConstruct
    public void init() 
    {
        simpleModel = new DefaultMapModel();
        /*gps=new Gps();
        gps.setLatitud(-16.21575262976786);
        gps.setLongitud(-48.00157736582031);
        this.gpsServicio.Insert(gps);*/
        //Shared coordinates
        int i=0;
        for(Gps g:this.gpsServicio.ObtenerLista())
        {            
            //LOG.log(Level.INFO,"l"+g.getLongitud()+"la"+g.getLatitud());
            LatLng coord1 = new LatLng(g.getLatitud(),g.getLongitud());
            //LatLng coord1 = new LatLng(-0.18659558628491135,-78.4305382);
            //LatLng coord1 = new LatLng(-78.4305382, -0.18659558628491135);
            //LatLng coord1 = new LatLng(36.879466, 30.667648);
            simpleModel.addOverlay(new Marker(coord1,coman.get(i)));
            i++;
        }
       
        /*LatLng coord1 = new LatLng(36.879466, 30.667648);
        LatLng coord2 = new LatLng(36.883707, 30.689216);
        LatLng coord3 = new LatLng(36.879703, 30.706707);
        LatLng coord4 = new LatLng(36.885233, 30.702323);
          
        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, "Konyaalti"));
        simpleModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
        simpleModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
        simpleModel.addOverlay(new Marker(coord4, "Kaleici"));*/
    }
      
    public MapModel getSimpleModel() {
        return simpleModel;
    }
      
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
         
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));
    }
      
    public Marker getMarker() {
        return marker;
    }
}
