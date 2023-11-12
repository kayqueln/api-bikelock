package br.com.bikelock.controller;

import br.com.bikelock.dto.Health;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/")
public class HealthController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Health lista() throws SQLException, ClassNotFoundException {
        Health health = new Health("health");
        return health;
    }
}
