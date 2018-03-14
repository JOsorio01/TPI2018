
package ues.edu.sv.tpi135_ingenieria.mantenimiento.servicioREST;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import ues.edu.sv.tpi135_ingenieria.mantenimiento.Lector;
/**
 *
 * @author esperanza
 */
//@Path("/mantenimiento")
public class MantenimientoServicioREST {
   Client cliente;
    WebTarget raiz;
    private final static String URL_RESOURCE = "http://localhost:8080/mantenimiento";
    public MantenimientoServicioREST(){
        this.cliente = ClientBuilder.newClient();
        this.raiz = cliente.target(URL_RESOURCE);
    }

    public URI crearMantenimiento(List<List<String>> lista) throws JSONException{
        //JSONArray jsonMantenimiento = new JSONArray();
        for (List<String> list : lista) {
            for (String string : list) {
                if (lista!=null && string.trim().isEmpty()) {
                    JsonObject nuevo = Json.createObjectBuilder().add("mantenimiento", string.trim().toUpperCase()).build();         
                    Response respuesta = raiz.path("mantenimientoraw").request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(Entity.json(nuevo));
                    if (respuesta!= null && respuesta.getStatus()==Response.Status.CREATED.getStatusCode()) {
                        return respuesta.getLocation();
                    }
                }  
            }
        }
        
    return null;
    }
}
