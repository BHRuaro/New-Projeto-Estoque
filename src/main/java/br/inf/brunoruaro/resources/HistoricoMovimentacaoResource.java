package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.controller.HistoricoMovimentacaoController;
import br.inf.brunoruaro.model.HistoricoMovimentacoes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/historico/movimentacoes")
public class HistoricoMovimentacaoResource {

    @Inject
    HistoricoMovimentacaoController historicoMovimentacaoController;

    @POST
    @Path("/create")
    @Transactional
    public Response historicoMovimentacaoCreate(HistoricoMovimentacoes historicoMovimentacoes){
        historicoMovimentacaoController.createHistoricoMovimentacoes(historicoMovimentacoes);
        return Response.ok().entity(historicoMovimentacoes.getHistoricoMovId()).build();
    }

    @PUT
    @Path("/update")
    @Transactional
    public Response historicoMovimentacaoUpdate(HistoricoMovimentacoes historicoMovimentacoes){
        return Response.ok().entity(historicoMovimentacaoController.updateHistoricoMovimentacoes(historicoMovimentacoes)).build();
    }

    @GET
    @Path("/list")
    @Transactional
    public Response historicoMovimentacaoList(){
        return Response.ok().entity(historicoMovimentacaoController.listHistoricoMovimentacoes()).build();
    }

    @GET
    @Path("/find")
    @Transactional
    public Response historicoMovimentacaoFind(Integer historicoId){
        return Response.ok().entity(historicoMovimentacaoController.findHistoricoMovimentacoes(historicoId)).build();
    }

    @DELETE
    @Path("/remove")
    @Transactional
    public Response historicoMovimentacaoDelete(Integer historicoId){
        historicoMovimentacaoController.removeHistoricoMovimentacoes(historicoId);
        return Response.ok().build();
    }
}
