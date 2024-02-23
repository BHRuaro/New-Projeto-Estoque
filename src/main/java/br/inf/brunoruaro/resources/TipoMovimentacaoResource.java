package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.controller.TipoMovimentacaoController;
import br.inf.brunoruaro.model.TipoMovimentacao;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/tipoMovimentacao")
public class TipoMovimentacaoResource {

    @Inject
    TipoMovimentacaoController tipoMovimentacaoController;

    @POST
    @Path("/create")
    @Transactional
    public Response createTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        Integer tipoMovimentacaoId = tipoMovimentacaoController.tipoMovimentacaoCreate(tipoMovimentacao);
        return Response.ok().entity(tipoMovimentacaoId).build();
    }

    @GET
    @Path("/list")
    @Transactional
    public Response getTipoMovimentacoes() {
        return Response.ok().entity(tipoMovimentacaoController.tipoMovimentacaoList()).build();
    }

    @GET
    @Path("/find")
    @Transactional
    public Response findTipoMovimentacoes(Integer tipoMovimentacaoId) {
        return Response.ok().entity(tipoMovimentacaoController.tipoMovimentacaoFind(tipoMovimentacaoId)).build();
    }

    @PUT
    @Path("/update")
    @Transactional
    public Response updateTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        return Response.ok().entity(tipoMovimentacaoController.tipoMovimentacaoUpdate(tipoMovimentacao)).build();
    }

    @DELETE
    @Path("/remove")
    @Transactional
    public  Response removeTipoMovimentacao(Integer tipoMovimentacaoId) {
        tipoMovimentacaoController.tipoMovimentacaoRemove(tipoMovimentacaoId);
        return Response.ok().build();
    }
}
