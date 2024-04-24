package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.controller.ItemController;
import br.inf.brunoruaro.error.ApiException;
import br.inf.brunoruaro.model.Item;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/item")
public class ItemResource {

    @Inject
    ItemController itemController;

    @POST
    @Path("/create")
    @Transactional
    public Response createItem(Item item) throws ApiException {
        Integer itemId = itemController.itemCreate(item);
        return Response.ok().entity(itemId).build();
    }

    @GET
    @Path("/list")
    @Transactional
    public Response listItem() throws ApiException{
        return Response.ok().entity(itemController.itemList()).build();
    }

    @GET
    @Path("/find")
    @Transactional
    public Response findItem(Integer itemId) throws ApiException{
        return Response.ok().entity(itemController.itemFind(itemId)).build();
    }

    @PUT
    @Path("/update")
    @Transactional
    public Response updateItem(Item item) throws ApiException{
        return Response.ok().entity(itemController.itemUpdate(item)).build();
    }

    @DELETE
    @Path("/remove")
    @Transactional
    public Response removeItem(Integer itemId) throws ApiException{
        itemController.itemRemove(itemId);
        return Response.ok().build();
    }
}
