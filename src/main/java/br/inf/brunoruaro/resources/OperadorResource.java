package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.controller.OperadorController;
import br.inf.brunoruaro.model.Operador;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;


@Path("/operador")
public class OperadorResource {

    @Inject
    OperadorController operadorController;

    @POST
    @Path("/create")
    @Transactional
    public Response createOperador(Operador operador) {
        Integer operadorId = operadorController.operadorCreate(operador);
        return Response.ok().entity(operadorId).build();
    }

    @GET
    @Path("/list")
    @Transactional
    public Response getOperadores() {
        return Response.ok().entity(operadorController.operadorList()).build();
    }

    @GET
    @Path("/find")
    @Transactional
    public Response findOperador(Integer operadorId) {
        return Response.ok().entity(operadorController.operadorFind(operadorId)).build();
    }

    @PUT
    @Path("/update")
    @Transactional
    public Response updateOperador(Operador operador) {
        return Response.ok().entity(operadorController.operadorUpdate(operador)).build();
    }
    //AJUSTE: no momento seta null os campos que não forem informados

    @DELETE
    @Path("/remove")
    @Transactional
    public Response removeOperador(Integer operadorId) {
        operadorController.operadorRemove(operadorId);
        return Response.ok().build();
    }

    @POST
    @Path("/login")
    @Transactional
    public Response loginOperador(Operador operador) {
        return Response.ok().entity(operadorController.operadorLogin(operador)).build();
    }
}
