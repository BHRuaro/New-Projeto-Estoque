package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.controller.MovimentacaoController;
import br.inf.brunoruaro.model.Movimentacao;
import com.google.gson.JsonParseException;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/movimentacao")
public class MovimentacaoResource {

    @Inject
    MovimentacaoController movimentacaoController;

    @POST
    @Path("/create")
    @Transactional
    public Response createMovimentacao(Movimentacao movimentacao){
        try{
            int resultado = movimentacaoController.movimentacaoCreate(movimentacao);
            if (resultado == 0){
                return Response.ok().entity("Erro ao criar movimentação").build();
            } else if (resultado == -1){
                return Response.ok().entity("Quantidade insuficiente em estoque").build();
            } else if (resultado == -2){
                return Response.ok().entity("Quantidade excede o limite de movimentação").build();
            } else if (resultado == -3) {
                return Response.ok().entity("Quantidade inválida").build();
            } else {
                return Response.ok().entity(resultado).build();
            }
        } catch (JsonParseException e){
            return Response.ok().entity("Erro ao criar movimentação:" + e.getMessage()).build();
        } catch (Exception e) {
        return Response.ok().entity("Erro ao criar movimentação: " + e.getMessage()).build();
    }
    }

    @PUT
    @Path("/update")
    @Transactional
    public Response updateMovimentacao(Movimentacao movimentacao){
        return Response.ok().entity(movimentacaoController.movimentacaoUpdate(movimentacao)).build();
    }

    @GET
    @Path("/list")
    @Transactional
    public Response listMovimentacao(){
        return Response.ok().entity(movimentacaoController.movimentacaoList()).build();
    }

    @GET
    @Path("/find")
    @Transactional
    public Response findMovimentacao(Integer movimentacaoId){
        return Response.ok().entity(movimentacaoController.movimentacaoFind(movimentacaoId)).build();
    }

    @DELETE
    @Path("/remove")
    @Transactional
    public Response removeMovimentacao(Integer movimentacaoId){
        movimentacaoController.movimentacaoRemove(movimentacaoId);
        return Response.ok().build();
    }
}
