package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.dto.UsuarioDto;
import br.inf.brunoruaro.error.ApiException;
import br.inf.brunoruaro.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import br.inf.brunoruaro.controller.UsuarioController;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.modelmapper.ModelMapper;

@ApplicationScoped
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UsuarioDto dto) throws ApiException {
        try{
            Integer usuarioId = usuarioController.create(toEntity(dto));
            return Response.ok().entity(usuarioId).build();
        }catch (ApiException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        }
    }

    @Override
    @PUT
    @Path("/update")
    @Transactional
    public Response update(UsuarioDto dto) throws ApiException {
        return Response.ok().entity(toDto(usuarioController.update(toEntity(dto)))).build();
    }

    @GET
    @Path("/find/{cpf}")
    @Transactional
    public Response findByCpf(@PathParam("cpf") Long cpf) throws ApiException {
        Usuario usuario = usuarioController.findByCpf(cpf);
        return Response.ok().entity(toDto(usuario)).build();
    }
}
