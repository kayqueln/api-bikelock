package br.com.bikelock.controller;

import br.com.bikelock.business.ModificacoesBusiness;
import br.com.bikelock.model.Modificacoes;
import br.com.bikelock.util.ErrorResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/modificacoes")
public class ModificacoesController {
    private ModificacoesBusiness business = new ModificacoesBusiness();
    ErrorResponse error = new ErrorResponse();

    @GET
    @Path("/lista-modificacoes")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Modificacoes> lista() throws SQLException, ClassNotFoundException {
        return (ArrayList<Modificacoes>) business.listarModificacoes();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastra(Modificacoes modificacoes) throws SQLException, ClassNotFoundException {
        business.inserirModificacao(modificacoes);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{idModificacao}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaPorID(@PathParam("idModificacao") Long idModificacao){
        try{
            var modificacoes = business.selecionarPorID(idModificacao);
            return Response.status(Response.Status.OK).entity(modificacoes).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @GET
    @Path("/numero-de-serie/{numeroDeSerie}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Modificacoes> buscaPorNumeroDeSerie(@PathParam("numeroDeSerie") String numeroDeSerie) throws Exception {
        return (ArrayList<Modificacoes>) business.listarPorNumeroDeSerie(numeroDeSerie);
    }

    @PUT
    @Path("/{idModificacao}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualiza(@PathParam("idModificacao") Long idModificacao, Modificacoes modificacoes) throws SQLException, ClassNotFoundException {
        business.atualizarModificacao(idModificacao, modificacoes);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{idModificacao}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleta(@PathParam("idModificacao") Long idModificacao) throws SQLException, ClassNotFoundException {
        business.deletarModificacao(idModificacao);
        return Response.noContent().build();
    }
}
