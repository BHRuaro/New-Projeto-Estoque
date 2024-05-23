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

    @Override
    @POST
    @Path("/create")
    @Transactional
    public Response create(FornecedorDto dto) throws ApiException {
        Fornecedor fornecedor = toEntity(dto);
        Integer id = fornecedorController.create(fornecedor);
        return Response.ok().entity(id).build();
    }

    @Override
    @PUT
    @Path("/update")
    @Transactional
    public Response update(FornecedorDto dto) throws ApiException {
        Fornecedor fornecedor = toEntity(dto);
        fornecedorController.update(fornecedor);
        return Response.ok().entity(dto).build();
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}
