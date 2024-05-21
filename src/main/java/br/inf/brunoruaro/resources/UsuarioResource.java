package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.dto.UsuarioDto;
import br.inf.brunoruaro.error.ApiException;
import br.inf.brunoruaro.model.Usuario;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import br.inf.brunoruaro.controller.UsuarioController;
import jakarta.ws.rs.core.Response;
import org.modelmapper.ModelMapper;

@Path("/usuario")
public class UsuarioResource extends CrudResource<Usuario, UsuarioDto>{

    @Inject
    UsuarioController usuarioController;

    @Inject
    ModelMapper modelMapper;

    public UsuarioResource() {
        super(Usuario.class, UsuarioDto.class);
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    @Override
    @POST
    @Path("/create")
    @Transactional
    public Response create(UsuarioDto dto) throws ApiException {
        Integer usuarioId = usuarioController.create(super.toEntity(dto));
        return Response.ok().entity(usuarioId).build();
    }

    @Override
    @PUT
    @Path("/update")
    @Transactional
    public Response update(UsuarioDto dto) throws ApiException {
        return Response.ok().entity(toDto(usuarioController.update(super.toEntity(dto)))).build();
    }
}
