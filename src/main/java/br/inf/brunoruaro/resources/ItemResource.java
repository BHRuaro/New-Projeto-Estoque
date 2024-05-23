package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.controller.ItemController;
import br.inf.brunoruaro.dto.ItemDto;
import br.inf.brunoruaro.error.ApiException;
import br.inf.brunoruaro.model.Item;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.modelmapper.ModelMapper;

@Path("/item")
public class ItemResource extends CrudResource<Item, ItemDto>{

    @Inject
    ItemController itemController;

    @Inject
    ModelMapper modelMapper;

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    public ItemResource() {
        super(Item.class, ItemDto.class);
    }

    @Override
    @POST
    @Path("/create")
    @Transactional
    public Response create(ItemDto dto) throws ApiException {
        Item item = toEntity(dto);
        Integer id = itemController.create(item);
        return Response.ok().entity(id).build();
    }

    @Override
    public Response update(ItemDto dto) throws ApiException {
        Item item = toEntity(dto);
        itemController.update(item);
        return Response.ok().entity(dto).build();
    }
}
