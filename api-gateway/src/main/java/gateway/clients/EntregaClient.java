package gateway.clients;

import gateway.dto.EntregaDto;
import gateway.dto.PassoDto;
import gateway.specification.validation.ValidationResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("centro-logistico")
public interface EntregaClient {

    @RequestMapping(value = "/entrega/{entregaid}", method = RequestMethod.GET)
    List<PassoDto> obterPassos(@PathVariable(value = "entregaid") String entregaid);

    @RequestMapping(value = "/entrega", method = RequestMethod.POST)
    ResponseEntity<ValidationResult> inserirEntrega(@RequestBody EntregaDto entregaDto);
}