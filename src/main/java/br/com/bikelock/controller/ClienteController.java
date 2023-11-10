package br.com.bikelock.controller;

import br.com.bikelock.business.BicicletaBusiness;
import br.com.bikelock.business.ClienteBusiness;
import br.com.bikelock.model.Bicicleta;
import br.com.bikelock.model.Cliente;
import br.com.bikelock.util.ErrorResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/cliente")
public class ClienteController {
    private ClienteBusiness business = new ClienteBusiness();
    ErrorResponse error = new ErrorResponse();



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastra(Cliente cliente, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        business.inserirCliente(cliente);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path((cliente.getEmail()));

        return Response.created(builder.build()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Cliente> lista(Bicicleta bicicleta, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        return (ArrayList<Cliente>) business.listarClientes();
    }

    @GET
    @Path("/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response busca(@PathParam("email") String email){
        try{
            var cliente = business.selecionarPorEmail(email);
            return Response.status(Response.Status.OK).entity(cliente).build();
        }catch (Exception e){
            error.setErro("E-mail não foi encontrado");
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }
    }

    @PUT
    @Path("/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualiza(@PathParam("email") String email, Cliente cliente) throws SQLException, ClassNotFoundException {
        business.atualizarCliente(email, cliente);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("email") String email) throws SQLException, ClassNotFoundException {
        business.deletarCliente(email);
        return Response.noContent().build();
    }
}
