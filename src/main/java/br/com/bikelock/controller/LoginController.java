package br.com.bikelock.controller;

import br.com.bikelock.business.LoginBusiness;
import br.com.bikelock.dto.DadosLoginCliente;
import br.com.bikelock.util.ErrorResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginController {

    LoginBusiness business = new LoginBusiness();
    ErrorResponse error = new ErrorResponse();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response busca(DadosLoginCliente dados){
        try{
            business.logar(dados);
            return Response.status(Response.Status.OK).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.FORBIDDEN).entity(error).build();
        }
    }

}
