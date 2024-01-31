package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.controller.OperadorController;
import br.inf.brunoruaro.model.Operador;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/operador")
public class OperadorResource {

    @Inject
    OperadorController operadorController;

    @POST
    @Transactional
    public Response createOperador(Operador operador) {
        Integer operadorId = operadorController.operadorCreate(operador);
        return Response.ok().entity(operadorId).build();
    }
}
