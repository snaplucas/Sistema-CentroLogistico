package port.adapter.entrypoints;

import application.dto.EntregaDto;
import application.dto.PassoDto;
import application.exceptions.EntregaException;
import application.interfaces.IEntregaAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shared.specification.validation.ValidationResult;

import java.util.List;

@RestController
@RequestMapping("/entrega")
public class EntregaController {

    private final IEntregaAppService entregaAppService;

    @Autowired
    public EntregaController(IEntregaAppService entregaAppService) {
        this.entregaAppService = entregaAppService;
    }

    @PostMapping
    public ResponseEntity<ValidationResult> inserirEntrega(@RequestBody EntregaDto entregaDto) {
        ValidationResult validationResult = entregaAppService.adicionarEntrega(entregaDto);
        if (validationResult.getErros().size() == 0) {
            return new ResponseEntity<>(validationResult, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(validationResult, HttpStatus.OK);
    }

    @GetMapping("/{entregaid}")
    public List<PassoDto> obterPassos(@PathVariable String entregaid) throws EntregaException {
        return entregaAppService.obterPassos(entregaid);
    }
}
