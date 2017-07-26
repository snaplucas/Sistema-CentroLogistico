package application.interfaces;

import application.dto.EntregaDto;
import application.dto.PassoDto;
import application.exceptions.EntregaException;
import shared.specification.validation.ValidationResult;

import java.util.List;

public interface IEntregaAppService {

    ValidationResult adicionarEntrega(EntregaDto entregaDto);

    List<PassoDto> obterPassos(String entregaId) throws EntregaException;
}
