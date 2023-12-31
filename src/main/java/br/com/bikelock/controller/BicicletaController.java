package br.com.bikelock.controller;

import br.com.bikelock.business.BicicletaBusiness;
import br.com.bikelock.model.Bicicleta;
import br.com.bikelock.util.ErrorResponse;


import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/bicicleta")
public class BicicletaController {

    private BicicletaBusiness business = new BicicletaBusiness();
    ErrorResponse error = new ErrorResponse();


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastra(Bicicleta bicicleta, @Context UriInfo uriInfo){
        try {
            business.inserirBicicleta(bicicleta);
            UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            builder.path((bicicleta.getNumeroSerie()));

            return Response.created(builder.build()).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Bicicleta> lista() throws SQLException, ClassNotFoundException {
        return (ArrayList<Bicicleta>) business.listarBicicletas();
    }

    @GET
    @Path("/{numeroDeSerie}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response busca(@PathParam("numeroDeSerie") String numeroDeSerie){
        try{
            var bicicleta = business.buscarPorNumeroDeSerie(numeroDeSerie);
            return Response.status(Response.Status.OK).entity(bicicleta).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @GET
    @Path("/email/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Bicicleta> buscaPorEmail(@PathParam("email") String email) throws Exception {
        return (ArrayList<Bicicleta>) business.buscarPorEmail(email);
    }

    @PUT
    @Path("/{numeroDeSerie}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualiza(@PathParam("numeroDeSerie") String numeroDeSerie, Bicicleta bicicleta) throws SQLException, ClassNotFoundException {
        business.atualizarBicicleta(numeroDeSerie, bicicleta);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{numeroDeSerie}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("numeroDeSerie") String numeroDeSerie) throws SQLException, ClassNotFoundException {
        business.deletarBicicleta(numeroDeSerie);
        return Response.noContent().build();
    }
}
