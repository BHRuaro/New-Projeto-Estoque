package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.controller.MovimentacaoController;
import br.inf.brunoruaro.dto.MovimentacaoDto;
import br.inf.brunoruaro.error.ApiException;
import br.inf.brunoruaro.model.Movimentacao;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.modelmapper.ModelMapper;

@Path("/movimentacao")
public class MovimentacaoResource extends CrudResource<Movimentacao, MovimentacaoDto>{

    @Inject
    MovimentacaoController movimentacaoController;

    @Inject
    ModelMapper modelMapper;

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    public MovimentacaoResource() {
        super(Movimentacao.class, MovimentacaoDto.class);
    }

    @Override
    @POST
    @Path("/create")
    @Transactional
    public Response create(MovimentacaoDto dto) throws ApiException {
        Movimentacao movimentacao = toEntity(dto);
        Integer id = movimentacaoController.create(movimentacao);
        return Response.ok().entity(id).build();
    }
}
