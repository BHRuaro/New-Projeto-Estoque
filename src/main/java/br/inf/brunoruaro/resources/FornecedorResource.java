package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.controller.FornecedorController;
import br.inf.brunoruaro.model.Fornecedor;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.Response;

@Path("/fornecedor")
public class FornecedorResource {

    @Inject
    FornecedorController fornecedorController;

    @POST
    @Path("/create")
    @Transactional
    public Response createOperador(Fornecedor fornecedor) {
        Integer operadorId = fornecedorController.fornecedorCreate(fornecedor);
        return Response.ok().entity(operadorId).build();
    }

    @GET
    @Path("/list")
    @Transactional
    public Response getFornecedores() {
        return Response.ok().entity(fornecedorController.fornecedorList()).build();
    }

    @GET
    @Path("/find")
    @Transactional
    public Response findFornecedor(Integer fornecedorId) {
        return Response.ok().entity(fornecedorController.fornecedorFind(fornecedorId)).build();
    }

    @DELETE
    @Path("/remove")
    @Transactional
    public Response removeFornecedor(Integer fornecedorId) {
        fornecedorController.fornecedorRemove(fornecedorId);
        return Response.ok().build();
    }

    @PUT
    @Path("/update")
    @Transactional
    public Response updateFornecedor(Fornecedor fornecedor) {
        return Response.ok().entity(fornecedorController.fornecedorUpdate(fornecedor)).build();
    }
    //AJUSTE: no momento seta null os campos que não forem informados

}
