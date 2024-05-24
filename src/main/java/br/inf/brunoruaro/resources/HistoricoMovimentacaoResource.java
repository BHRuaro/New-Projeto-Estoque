package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.controller.HistoricoMovimentacaoController;
import br.inf.brunoruaro.dto.HistoricoMovimentacaoDto;
import br.inf.brunoruaro.model.HistoricoMovimentacoes;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.modelmapper.ModelMapper;

@Path("/historico/movimentacoes")
public class HistoricoMovimentacaoResource extends CrudResource<HistoricoMovimentacoes, HistoricoMovimentacaoDto> {

    @Inject
    HistoricoMovimentacaoController historicoMovimentacaoController;

    @Inject
    ModelMapper modelMapper;

    public HistoricoMovimentacaoResource() {
        super(HistoricoMovimentacoes.class, HistoricoMovimentacaoDto.class);
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}
