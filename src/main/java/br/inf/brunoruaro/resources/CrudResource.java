package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.controller.CrudController;
import br.inf.brunoruaro.error.ApiException;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CrudResource <T, D> {

    @Inject
    CrudController<T> crudController;

    protected abstract ModelMapper getModelMapper();

    private final Class<T> typeClass;
    private final Class<D> typeDtoClass;

    public CrudResource(Class<T> typeClass, Class<D> typeDtoClass) {
        this.typeClass = typeClass;
        this.typeDtoClass = typeDtoClass;
    }

    D toDto(T entity) {
        return getModelMapper().map(entity, this.typeDtoClass);
    }

    T toEntity(D dto) {
        return getModelMapper().map(dto, this.typeClass);
    }

    @POST
    @Path("/create")
    @Transactional
    public Response create(D dto) throws ApiException {
        T entity = toEntity(dto);
        Integer id = crudController.create(entity);
        return Response.ok().entity(id).build();
    }

    @GET
    @Path("/find/{id}")
    @Transactional
    public Response find(@PathParam("id") Integer id) throws ApiException {
        T entity = crudController.find(id);
        D dto = toDto(entity);
        return Response.ok().entity(dto).build();
    }

    @PUT
    @Path("/update")
    @Transactional
    public Response update(D dto) throws ApiException {
        T entity = toEntity(dto);
        crudController.update(entity);
        return Response.ok().entity(entity).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response delete(@PathParam("id") Integer id) throws ApiException {
        crudController.delete(id);
        return Response.ok().build();
    }

    @GET
    @Path("/list")
    @Transactional
    public Response list() throws ApiException {
        List<T> entities = crudController.list();
        List<D> dtos = entities.stream().map(this::toDto).collect(Collectors.toList());
        return Response.ok().entity(dtos).build();
    }

    @GET
    @Path("/getByName")
    @Transactional
    public Response getByName(String name) throws ApiException {
        List<T> entities = crudController.getByName(name);
        List<D> dtos = entities.stream().map(this::toDto).collect(Collectors.toList());
        return Response.ok().entity(dtos).build();
    }
}
