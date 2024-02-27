package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.controller.HistoricoCadastrosController;
import br.inf.brunoruaro.model.HistoricoCadastros;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/historico/cadastros")
public class HistoricoCadastroResource {

    @Inject
    HistoricoCadastrosController historicoCadastrosController;

    @POST
    @Path("/create")
    @Transactional
    public Response historicoCadastrosCreate(HistoricoCadastros historicoCadastros){
        historicoCadastrosController.createHistoricoCadastros(historicoCadastros);
        return Response.ok().entity(historicoCadastros.getHistoricoCadId()).build();
    }

    @PUT
    @Path("/update")
    @Transactional
    public Response historicoCadastrosUpdate(HistoricoCadastros historicoCadastros){
        return Response.ok().entity(historicoCadastrosController.updateHistoricoCadastros(historicoCadastros)).build();
    }

    @GET
    @Path("/list")
    @Transactional
    public Response historicoCadastrosList(){
        return Response.ok().entity(historicoCadastrosController.listHistoricoCadastros()).build();
    }

    @GET
    @Path("/find")
    @Transactional
    public Response historicoCadastrosFind(Integer historicoId){
        return Response.ok().entity(historicoCadastrosController.findHistoricoCadastros(historicoId)).build();
    }

    @DELETE
    @Path("/remove")
    @Transactional
    public Response historicoCadastrosDelete(Integer historicoId){
        historicoCadastrosController.removeHistoricoCadastros(historicoId);
        return Response.ok().build();
    }
}
