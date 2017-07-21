package application.services;

import application.dto.EntregaDto;
import application.dto.PacoteDto;
import application.dto.PassoDto;
import application.exceptions.EntregaException;
import application.interfaces.IEntregaAppService;
import domain.model.entities.Entrega;
import domain.model.entities.Pacote;
import domain.model.entities.Passo;
import domain.model.interfaces.IEntregaService;
import port.adapter.specification.validation.ValidationResult;

import java.util.List;
import java.util.stream.Collectors;

public class EntregaAppService implements IEntregaAppService {

    private final IEntregaService entregaService;

    public EntregaAppService(IEntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @Override
    public ValidationResult adicionarEntrega(EntregaDto entregaDto) {
        Entrega entrega = toDomainModel(entregaDto);
        if (entrega.isValid()) {
            entregaService.adicionarEntrega(entrega);
        }
        return entrega.getValidationResult();
    }

    @Override
    public List<PassoDto> obterPassos(String entregaId) throws EntregaException {
        Entrega entrega = entregaService.obterEntrega(entregaId);
        if (entrega != null) {
            return entrega.definirPassos().stream().map(this::toDto).collect(Collectors.toList());
        }
        throw new EntregaException("Entrega não encotrada");
    }

    private Entrega toDomainModel(EntregaDto entregaDto) {
        Entrega entrega = new Entrega();
        entrega.setPacotes(entregaDto.getPacotes().stream().map(this::toDomainModel).collect(Collectors.toList()));
        entrega.setId(entregaDto.getId());
        entrega.setVeiculo(entregaDto.getVeiculo());
        return entrega;
    }

    private PassoDto toDto(Passo passo) {
        PassoDto passoDto = new PassoDto();
        passoDto.setDe(passo.getDe());
        passoDto.setPara(passo.getPara());
        passoDto.setPacoteId(passo.getPacoteId());
        return passoDto;
    }

    private Pacote toDomainModel(PacoteDto pacoteDto) {
        Pacote pacote = new Pacote();
        pacote.setId(pacoteDto.getId());
        pacote.setPeso(pacoteDto.getPeso());
        return pacote;
    }
}
