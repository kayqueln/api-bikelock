package br.com.bikelock.controller;

import br.com.bikelock.business.EnderecoBusiness;
import br.com.bikelock.model.Endereco;
import br.com.bikelock.util.ErrorResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/endereco")
public class EnderecoController {

    private EnderecoBusiness business = new EnderecoBusiness();
    ErrorResponse error = new ErrorResponse();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastra(Endereco endereco) throws SQLException, ClassNotFoundException {
        business.inserirEndereco(endereco);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/lista-enderecos")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Endereco> lista() throws SQLException, ClassNotFoundException {
        return (ArrayList<Endereco>) business.listarEndereco();
    }

    @GET
    @Path("/{idEndereco}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response busca(@PathParam("idEndereco") Long idEndereco){
        try{
            var endereco = business.selecionarPorID(idEndereco);
            return Response.status(Response.Status.OK).entity(endereco).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @GET
    @Path("/email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Endereco> listaPorEmail(@PathParam("email") String email) throws SQLException, ClassNotFoundException {
        return (ArrayList<Endereco>) business.listarPorEmail(email);
    }

    @PUT
    @Path("/{idEndereco}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualiza(@PathParam("idEndereco") Long idEndereco, Endereco endereco) throws SQLException, ClassNotFoundException {
        business.atualizarEndereco(idEndereco, endereco);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{idEndereco}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleta(@PathParam("idEndereco") Long idEndereco) throws SQLException, ClassNotFoundException {
        business.deletarEndereco(idEndereco);
        return Response.noContent().build();
    }
}
