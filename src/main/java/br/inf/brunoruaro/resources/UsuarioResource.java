package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.error.ApiException;
import br.inf.brunoruaro.model.Usuario;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import br.inf.brunoruaro.controller.UsuarioController;
import jakarta.ws.rs.core.Response;

@Path("/usuario")
public class UsuarioResource {

    @Inject
    UsuarioController usuarioController;

    @POST
    @Path("/create")
    @Transactional
    public Response createUsuario(Usuario usuario) throws ApiException {
        Integer usuarioId = usuarioController.usuarioCreate(usuario);
        return Response.ok().entity(usuarioId).build();
    }

    @GET
    @Path("/list")
    @Transactional
    public Response getUsuarios() throws ApiException{
        return Response.ok().entity(usuarioController.usuarioList()).build();
    }

    @GET
    @Path("/find")
    @Transactional
    public Response findUsuario(Integer usuarioId) throws ApiException {
        return Response.ok().entity(usuarioController.usuarioFind(usuarioId)).build();
    }

    @PUT
    @Path("/update")
    @Transactional
    public Response updateUsuario(Usuario usuario) throws ApiException{
        return Response.ok().entity(usuarioController.usuarioUpdate(usuario)).build();
    }

    @DELETE
    @Path("/remove")
    @Transactional
    public Response removeUsuario(Integer usuarioId) throws ApiException{
        usuarioController.usuarioRemove(usuarioId);
        return Response.ok().build();
    }

}
