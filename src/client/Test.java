package client;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import pojos.Onibus;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

import dao.OnibusDAO;

/**
 * Código desenvolvido por Christiam Masdeval
 * @author Christiam Masdeval
 * 
 * Adaptado por @tgmarinho
 *
 */

public class Test {
  public static void main(String[] args) {
      
      OnibusDAO onibusDAO = new OnibusDAO();
      
      Onibus o = new Onibus();
      
      o.setNome("Maria Ap Pedrossian - Oiti");
      o.setLatitude(1.6);
      o.setLongitude(1.3);      
      
      onibusDAO.create(o);     
      
//      o = onibusDAO.find(1);      
      System.out.println(o);
      
//      o.setNome("Lageado");
//      o.setLatitude(-2.34567);
//      onibusDAO.edit(o);   
      
      
    ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
    WebResource service = client.resource(getBaseURI());
    // Fluent interfaces
    //System.out.println(service.path("rest").path("hello").accept(MediaType.TEXT_PLAIN).get(ClientResponse.class).toString());
    // Get plain text
   // System.out.println(service.path("rest").path("onibus/1").accept(MediaType.APPLICATION_JSON).get(String.class));
    //System.out.println(service.path("rest").path("onibus/23").accept(MediaType.APPLICATION_XML_TYPE).get(String.class));
    // Get XML
    //System.out.println(service.path("rest").path("hello").accept(MediaType.TEXT_XML).get(String.class));
    // The HTML
    //System.out.println(service.path("rest").path("hello").accept(MediaType.TEXT_HTML).get(String.class));

   //Insere um objeto baseado em um formulario
    Form form = new Form();
    form.add("latitude", "4.0");
    form.add("nome", "Moreninha");
    form.add("longitude","-4.0");
   // service.path("rest").path("onibus").type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, form);
    
    //Insere um objeto pasando a representacao JSON do mesmo
//    Gson gson = new Gson();
//    Onibus on = new Onibus();
//    on.setId(2);
//    on.setNome("Teste JSON");
//    on.setLatitude(1.2);
//    on.setLongitude(1.3);      
//    String onibus = gson.toJson(o);
    //service.path("rest").path("onibus").type(MediaType.APPLICATION_JSON).post(ClientResponse.class, onibus);
    
    
  }

  private static URI getBaseURI() {
    return UriBuilder.fromUri("http://127.0.0.1:8089/ServerBus/").build();
  
  }

} 