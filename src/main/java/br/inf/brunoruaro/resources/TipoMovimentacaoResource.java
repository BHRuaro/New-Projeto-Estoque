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

    @Inject
    ModelMapper modelMapper;

    public TipoMovimentacaoResource() {
        super(TipoMovimentacao.class, TipoMovimentacaoDTO.class);
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}
