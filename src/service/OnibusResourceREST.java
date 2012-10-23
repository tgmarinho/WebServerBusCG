
package service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import pojos.Onibus;
import dao.OnibusDAO;
import exception.NoContentException;

/**
 * Código cedido por Christiam Masdeval
 * 
 * Adaptação do código @tgmarinho
 * 
 */

/** WebService responsável por receber solicitações HTTP, adivindas das aplicações BusCgSender e BusCg,
 *  a primeira utiliza o método alterar dessa classe e a segunda aplição utiliza o método getOnibus
*/

@Path("/onibus")
public class OnibusResourceREST {

	OnibusDAO onibusDAO = new OnibusDAO();

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Onibus getOnibus(@PathParam("id") String id) {
		Onibus o = onibusDAO.find(Integer.valueOf(id));

		if (o == null)
			throw new NoContentException("Onibus nao encontrado.");

		return onibusDAO.find(Integer.valueOf(id));
	}

	/*
	 * Insere um novo registro de geolocalização no banco. Recebe dados de um
	 * formulario
	 */
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newOnibus(@FormParam("nome") String nome,
			@FormParam("latitude") Double latitude,
			@FormParam("longitude") Double longitude,
			@Context HttpServletResponse servletResponse) throws IOException {

		Onibus o = new Onibus();
		o.setNome(nome);
		o.setLatitude(latitude);
		o.setLongitude(longitude);

		onibusDAO.create(o);

	}

	/*
	 * Insere um novo registro de geolocalização no banco. Recebe dados de um
	 * formulario
	 */
	@POST
	// @Path("/inserir")
	// @Produces("application/json")
	@Consumes("application/json")
	public void inserir(Onibus o) {
		onibusDAO.create(o);
	}

	/*
	 * Atualiza um registro
	 */
	@PUT
	@Consumes("application/json")
	public void alterar(Onibus o) {
		onibusDAO.edit(o);
	}

}
