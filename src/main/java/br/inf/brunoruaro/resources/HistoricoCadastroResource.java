package br.inf.brunoruaro.resources;

import br.inf.brunoruaro.controller.HistoricoCadastrosController;
import br.inf.brunoruaro.dto.HistoricoCadastroDto;
import br.inf.brunoruaro.model.HistoricoCadastros;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.modelmapper.ModelMapper;

@Path("/historico/cadastros")
public class HistoricoCadastroResource extends CrudResource<HistoricoCadastros, HistoricoCadastroDto>{

    @Inject
    HistoricoCadastrosController historicoCadastrosController;

    @Inject
    ModelMapper modelMapper;

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    public HistoricoCadastroResource() {
        super(HistoricoCadastros.class, HistoricoCadastroDto.class);
    }
}
