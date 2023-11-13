package br.com.bikelock.controller;

import br.com.bikelock.business.SeguroBusiness;
import br.com.bikelock.dto.SimulacaoSeguro;
import br.com.bikelock.model.Seguro;
import br.com.bikelock.util.ErrorResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/seguro")
public class SeguroController {

    private SeguroBusiness business = new SeguroBusiness();
    ErrorResponse error = new ErrorResponse();

    @POST
    @Path("/simular")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response simularSeguro(SimulacaoSeguro simulacaoSeguro) throws SQLException, ClassNotFoundException {
        business.simularSeguro(simulacaoSeguro.getNumeroDeSerie(), simulacaoSeguro.getTipoSeguro());
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/confirmar/{idSeguro}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response confirmar(@PathParam("idSeguro") Long idSeguro) throws SQLException, ClassNotFoundException {
        try {
            business.confirmarSeguro(idSeguro);
            return Response.status(Response.Status.OK).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @PUT
    @Path("/recusar/{idSeguro}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response recusar(@PathParam("idSeguro") Long idSeguro) throws SQLException, ClassNotFoundException {
        try {
            business.recusarSeguro(idSeguro);
            return Response.status(Response.Status.OK).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Seguro> lista() throws SQLException, ClassNotFoundException {
        return (ArrayList<Seguro>) business.listarSeguros();
    }

    @GET
    @Path("/{idSeguro}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaPorID(@PathParam("idSeguro") Long idSeguro){
        try{
            var seguro = business.selecionarPorID(idSeguro);

            return Response.status(Response.Status.OK).entity(seguro).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @GET
    @Path("/email/{emailCliente}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaPorEmail(@PathParam("emailCliente") String emailCliente){
        try{
            var seguro = business.selecionarPorEmail(emailCliente);
            return Response.status(Response.Status.OK).entity(seguro).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @GET
    @Path("/numero-de-serie/{numeroDeSerie}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaPorNumeroDeSerie(@PathParam("numeroDeSerie") String numeroDeSerie){
        try{
            var seguro = business.selecionarPorNumeroDeSerie(numeroDeSerie);
            return Response.status(Response.Status.OK).entity(seguro).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @PUT
    @Path("/{idSeguro}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualiza(@PathParam("idSeguro") Long idEndereco, Seguro seguro) throws SQLException, ClassNotFoundException {
        business.atualizarSeguro(idEndereco, seguro);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{idSeguro}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleta(@PathParam("idSeguro") Long idSeguro) throws SQLException, ClassNotFoundException {
        business.deletarSeguro(idSeguro);
        return Response.noContent().build();
    }
}
