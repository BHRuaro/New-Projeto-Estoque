package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.controller.FornecedorController;
import br.inf.brunoruaro.error.ApiException;
import br.inf.brunoruaro.model.Fornecedor;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/fornecedor")
public class FornecedorResource {

    @Inject
    FornecedorController fornecedorController;

    @POST
    @Path("/create")
    @Transactional
    public Response createFornecedor(Fornecedor fornecedor) throws ApiException {
        Integer fornecedorId = fornecedorController.fornecedorCreate(fornecedor);
        return Response.ok().entity(fornecedorId).build();
    }

    @GET
    @Path("/list")
    @Transactional
    public Response getFornecedores() throws ApiException {
        return Response.ok().entity(fornecedorController.fornecedorList()).build();
    }

    @GET
    @Path("/find")
    @Transactional
    public Response findFornecedor(Integer fornecedorId) throws ApiException {
        return Response.ok().entity(fornecedorController.fornecedorFind(fornecedorId)).build();
    }

    @DELETE
    @Path("/remove")
    @Transactional
    public Response removeFornecedor(Integer fornecedorId) throws ApiException {
        fornecedorController.fornecedorRemove(fornecedorId);
        return Response.ok().entity("Removido com sucesso").build();
    }

    @PUT
    @Path("/update")
    @Transactional
    public Response updateFornecedor(Fornecedor fornecedor) throws ApiException{
        return Response.ok().entity(fornecedorController.fornecedorUpdate(fornecedor)).build();
    }

}
