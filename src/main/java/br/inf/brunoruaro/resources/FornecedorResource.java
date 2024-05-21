package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.controller.FornecedorController;
import br.inf.brunoruaro.dto.FornecedorDto;
import br.inf.brunoruaro.error.ApiException;
import br.inf.brunoruaro.model.Fornecedor;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.modelmapper.ModelMapper;

@Path("/fornecedor")
public class FornecedorResource extends CrudResource<Fornecedor, FornecedorDto>{

    @Inject
    FornecedorController fornecedorController;

    @Inject
    ModelMapper modelMapper;

    public FornecedorResource() {
        super(Fornecedor.class, FornecedorDto.class);
    }

    @POST
    @Path("/create")
    @Transactional
    public Response createFornecedor(Fornecedor fornecedor) throws ApiException {
        Integer fornecedorId = fornecedorController.create(fornecedor);
        return Response.ok().entity(fornecedorId).build();
    }

    @PUT
    @Path("/update")
    @Transactional
    public Response updateFornecedor(Fornecedor fornecedor) throws ApiException{
        return Response.ok().entity(fornecedorController.update(fornecedor)).build();
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}
