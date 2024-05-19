package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.controller.TipoMovimentacaoController;
import br.inf.brunoruaro.dto.TipoMovimentacaoDTO;
import br.inf.brunoruaro.model.TipoMovimentacao;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.modelmapper.ModelMapper;

@Path("/tipoMovimentacao")
public class TipoMovimentacaoResource extends CrudResource<TipoMovimentacao, TipoMovimentacaoDTO>{

    @Inject
    TipoMovimentacaoController tipoMovimentacaoController;

    private final ModelMapper modelMapper;

    public TipoMovimentacaoResource(Class<TipoMovimentacao> typeClass, Class<TipoMovimentacaoDTO> typeDtoClass, ModelMapper modelMapper) {
        super(typeClass, typeDtoClass);
        this.modelMapper = modelMapper;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}
