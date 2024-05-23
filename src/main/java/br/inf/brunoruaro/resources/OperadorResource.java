package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.controller.OperadorController;
import br.inf.brunoruaro.dto.OperadorDto;
import br.inf.brunoruaro.dto.OperadorDtoExibicao;
import br.inf.brunoruaro.error.ApiException;
import br.inf.brunoruaro.model.Operador;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.modelmapper.ModelMapper;


@Path("/operador")
public class OperadorResource extends CrudResource<Operador, OperadorDto>{

    @Inject
    OperadorController operadorController;

    @Inject
    ModelMapper modelMapper;

    public OperadorResource() {
        super(Operador.class, OperadorDto.class);
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    @Override
    public Response update(OperadorDto dto) throws ApiException {
        Operador operador = toEntity(dto);
        crudController.update(operador);
        OperadorDtoExibicao operadorDtoExibicao = getModelMapper().map(operador, OperadorDtoExibicao.class);

        return Response.ok().entity(operadorDtoExibicao).build();
    }

    @POST
    @Path("/login")
    @Transactional
    public Response login(Operador operador) {
        return Response.ok().entity(operadorController.operadorLogin(operador)).build();
    }
}
