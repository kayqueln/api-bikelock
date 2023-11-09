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
            if(business.logar(dados.getEmail(), dados.getSenha())){
                return Response.status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.FORBIDDEN).build();
            }
        }catch (Exception e){
            error.setErro("Usuário não encontrado");
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }
    }

}
